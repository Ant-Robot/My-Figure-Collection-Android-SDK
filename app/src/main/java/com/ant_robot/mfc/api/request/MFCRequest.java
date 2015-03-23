package com.ant_robot.mfc.api.request;

import android.content.Context;
import android.widget.TextView;

import com.ant_robot.mfc.api.request.cookie.PersistentCookieStore;
import com.ant_robot.mfcapi.R;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
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
import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;
import rx.Observable;


public enum MFCRequest {
    INSTANCE;
    public static final String ROOT = "http://myfigurecollection.net/api.php";
    public static final String LOGIN = "https://secure.myfigurecollection.net/signs.php";
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

    public CollectionService getCollectionService() {
        return restAdapter.create(CollectionService.class);
    }

    /**
     * Helper to retrieve connection request
     *
     * @param username the user login name
     * @param password the user password
     * @param context  an application context for the cookie store
     * @param callback returns success true if connection succeed, success false if everything went ok but connexion failed, a failure otherwise
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


    static class DynamicJsonConverter implements Converter {

        @Override
        public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
            try {
                InputStream in = typedInput.in(); // convert the typedInput to String
                String string = fromStream(in);
                in.close(); // we are responsible to close the InputStream after use

                string = StringUtils.replace(string, "{}", "null");
                //string = StringUtils.replace(string, "0000-00-00", "null");

                if (String.class.equals(type)) {
                    return string;
                } else {
                    return new GsonBuilder()
                            .setDateFormat("yyyy-MM-dd")
                            .create().fromJson(string, type); // convert to the supplied type, typically Object, JsonObject or Map<String, Object>
                }
            } catch (Exception e) { // a lot may happen here, whatever happens
                throw new ConversionException(e); // wrap it into ConversionException so retrofit can process it
            }
        }

        @Override
        public TypedOutput toBody(Object object) { // not required
            return null;
        }

        private static String fromStream(InputStream in) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append("\r\n");
            }
            return out.toString();
        }
    }


}
