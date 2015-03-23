package com.ant_robot.mfc.api.request;

import android.content.Context;

import com.ant_robot.mfc.api.request.cookie.PersistentCookieStore;
import com.ant_robot.mfc.api.request.service.CollectionService;
import com.ant_robot.mfc.api.request.service.ConnexionService;
import com.squareup.okhttp.OkHttpClient;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;


public enum MFCRequest {
    INSTANCE;
    public static final String ROOT = "http://myfigurecollection.net/api.php";
    public static final String LOGIN = "https://secure.myfigurecollection.net/signs.php";
    public static final String ITEM = "http://myfigurecollection.net/items.php";
    private final RestAdapter restAdapter;
    private final RestAdapter connectAdapter;
    private final OkHttpClient client;

    private MFCRequest() {
        client = new OkHttpClient();
        client.setConnectTimeout(60, TimeUnit.SECONDS);
        client.setReadTimeout(60, TimeUnit.SECONDS);
        client.setFollowRedirects(false);


        restAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setConverter(new DynamicJsonConverter())
                .setEndpoint(ROOT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        connectAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(LOGIN)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public RestAdapter getRestAdapter() {
        return restAdapter;
    }

    public RestAdapter getConnectAdapter() {
        return connectAdapter;
    }

    public OkHttpClient getClient() {
        return client;
    }


    public CollectionService getCollectionService() {
        return restAdapter.create(CollectionService.class);
    }

    /**
     * Helper to retrieve connection request
     *
     * @param username the user login name
     * @param password the user password
     * @param context  an application context for the cookie store
     * @param callback calls success true if connection succeed, calls success false if everything went ok but connexion failed, calls failure otherwise
     */
    public void getConnexionService(String username, String password, final Context context, final Callback<Boolean> callback) {
        client.setCookieHandler(new CookieManager(
                new PersistentCookieStore(context),
                CookiePolicy.ACCEPT_ALL));

        connectAdapter.create(ConnexionService.class).connectUser(username, password, 1, "signin", "http://myfigurecollection.net/", new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                //Request went well, but MFC should return a HTTP 302 status if connection succeeded
                callback.success(Boolean.FALSE, response);
            }

            @Override
            public void failure(RetrofitError error) {
                switch (error.getKind()) {
                    case HTTP:
                        switch (error.getResponse().getStatus()) {
                            //if we have a HTTP 302 redirection with an empty body that means we logged in
                            case 302:
                                try {
                                    PersistentCookieStore persistentCookieStore = new PersistentCookieStore(context);
                                    List l = persistentCookieStore.get(new URI("https://.myfigurecollection.net/"));
                                    callback.success(l.size() > 0, error.getResponse());
                                    break;
                                } catch (URISyntaxException e) {
                                    e.printStackTrace();
                                }
                            default:
                                callback.failure(error);
                                break;
                        }
                        break;

                    case NETWORK:
                        callback.failure(error);
                        break;

                    case CONVERSION:
                    case UNEXPECTED:
                        throw error;

                    default:
                        throw new AssertionError("Unknown error kind: " + error.getKind());
                }
            }
        });
    }


}
