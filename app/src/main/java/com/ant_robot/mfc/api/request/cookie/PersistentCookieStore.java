package com.ant_robot.mfc.api.request.cookie;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
 
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class PersistentCookieStore implements CookieStore {
    private static final String TAG = PersistentCookieStore.class
			.getSimpleName();
 
	// Persistence
	private static final String SP_COOKIE_STORE = "cookieStore";
	private static final String SP_KEY_DELIMITER = "|"; // Unusual char in URL
	private static final String SP_KEY_DELIMITER_REGEX = "\\"
			+ SP_KEY_DELIMITER;
	private SharedPreferences sharedPreferences;
 
	// In memory
	private Map<URI, Set<HttpCookie>> allCookies;
 
	public PersistentCookieStore(Context context) {
		sharedPreferences = context.getSharedPreferences(SP_COOKIE_STORE,
				Context.MODE_PRIVATE);
		loadAllFromPersistence();
	}
 
	private void loadAllFromPersistence() {
		allCookies = new HashMap<URI, Set<HttpCookie>>();
 
		Map<String, ?> allPairs = sharedPreferences.getAll();
		for (Entry<String, ?> entry : allPairs.entrySet()) {
			String[] uriAndName = entry.getKey().split(SP_KEY_DELIMITER_REGEX,
					2);
			try {
				URI uri = new URI(uriAndName[0]);
				String encodedCookie = (String) entry.getValue();
				HttpCookie cookie = new SerializableHttpCookie()
						.decode(encodedCookie);
 
				Set<HttpCookie> targetCookies = allCookies.get(uri);
				if (targetCookies == null) {
					targetCookies = new HashSet<HttpCookie>();
					allCookies.put(uri, targetCookies);
				}
				// Repeated cookies cannot exist in persistence
				// targetCookies.remove(cookie)
				targetCookies.add(cookie);
			} catch (URISyntaxException e) {
				Log.w(TAG, e);
			}
 
		}
	}
 
	@Override
	public synchronized void add(URI uri, HttpCookie cookie) {
		uri = cookieUri(uri, cookie);
 
		Set<HttpCookie> targetCookies = allCookies.get(uri);
		if (targetCookies == null) {
			targetCookies = new HashSet<HttpCookie>();
			allCookies.put(uri, targetCookies);
		}
		targetCookies.remove(cookie);
		targetCookies.add(cookie);
 
		saveToPersistence(uri, cookie);
	}
 
	/**
	 * Get the real URI from the cookie "domain" and "path" attributes, if they
	 * are not set then uses the URI provided (coming from the response)
	 * 
	 * @param uri
	 * @param cookie
	 * @return
	 */
	private static URI cookieUri(URI uri, HttpCookie cookie) {
		URI cookieUri = uri;
		if (cookie.getDomain() != null) {
			try {
				cookieUri = new URI(uri.getScheme() == null ? "http"
						: uri.getScheme(), cookie.getDomain(),
						cookie.getPath() == null ? "/" : cookie.getPath(), null);
			} catch (URISyntaxException e) {
				Log.w(TAG, e);
			}
		}
		return cookieUri;
	}
 
	private void saveToPersistence(URI uri, HttpCookie cookie) {
		SharedPreferences.Editor editor = sharedPreferences.edit();
 
		editor.putString(uri.toString() + SP_KEY_DELIMITER + cookie.getName(),
				new SerializableHttpCookie().encode(cookie));
 
		editor.apply();
	}
 
	@Override
	public synchronized List<HttpCookie> get(URI uri) {
		return getValidCookies(uri);
	}
 
	@Override
	public synchronized List<HttpCookie> getCookies() {
		List<HttpCookie> allValidCookies = new ArrayList<HttpCookie>();
		for (Iterator<URI> it = allCookies.keySet().iterator(); it.hasNext();) {
			allValidCookies.addAll(getValidCookies(it.next()));
		}
 
		return allValidCookies;
	}
 
	private List<HttpCookie> getValidCookies(URI uri) {
		Set<HttpCookie> targetCookies = new HashSet<HttpCookie>();
		// If the stored URI does not have a path then it must match any URI in
		// the same domain
		for (Iterator<URI> it = allCookies.keySet().iterator(); it.hasNext();) {
			URI storedUri = it.next();
			// Check if the two domains are the same
			if (storedUri.getHost().equals(uri.getHost())) {
				// Check if the stored path is null or "/"
				// OR
				// if the two the paths are the same
				if ((storedUri.getPath() == null || storedUri.getPath().equals(
						"/"))
						|| storedUri.getPath().equals(uri.getPath())) {
 
					targetCookies.addAll(allCookies.get(storedUri));
				}
			}
		}
 
		// Check it there are expired cookies and remove them
		if (targetCookies != null) {
			List<HttpCookie> cookiesToRemoveFromPersistence = new ArrayList<HttpCookie>();
			for (Iterator<HttpCookie> it = targetCookies.iterator(); it
					.hasNext();) {
				HttpCookie currentCookie = it.next();
				if (currentCookie.hasExpired()) {
					cookiesToRemoveFromPersistence.add(currentCookie);
					it.remove();
				}
			}
 
			if (!cookiesToRemoveFromPersistence.isEmpty()) {
				removeFromPersistence(uri, cookiesToRemoveFromPersistence);
			}
		}
		return new ArrayList<HttpCookie>(targetCookies);
	}
 
	private void removeFromPersistence(URI uri, List<HttpCookie> cookiesToRemove) {
		SharedPreferences.Editor editor = sharedPreferences.edit();
		for (HttpCookie cookieToRemove : cookiesToRemove) {
			editor.remove(uri.toString() + SP_KEY_DELIMITER
					+ cookieToRemove.getName());
		}
		editor.apply();
	}
 
	@Override
	public synchronized List<URI> getURIs() {
		return new ArrayList<URI>(allCookies.keySet());
	}
 
	@Override
	public synchronized boolean remove(URI uri, HttpCookie cookie) {
		Set<HttpCookie> targetCookies = allCookies.get(uri);
		boolean cookieRemoved = targetCookies != null ? targetCookies
				.remove(cookie) : false;
		if (cookieRemoved) {
			removeFromPersistence(uri, cookie);
		}
		return cookieRemoved;
 
	}
 
	private void removeFromPersistence(URI uri, HttpCookie cookieToRemove) {
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.remove(uri.toString() + SP_KEY_DELIMITER
				+ cookieToRemove.getName());
		editor.apply();
	}
 
	@Override
	public synchronized boolean removeAll() {
		allCookies.clear();
		removeAllFromPersistence();
		return true;
	}
 
	private void removeAllFromPersistence() {
		sharedPreferences.edit().clear().apply();
	}
 
}