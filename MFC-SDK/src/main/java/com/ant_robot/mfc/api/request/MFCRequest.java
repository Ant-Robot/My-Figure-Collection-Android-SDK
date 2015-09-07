package com.ant_robot.mfc.api.request;

import android.content.Context;

import com.ant_robot.mfc.api.pojo.AlterItem;
import com.ant_robot.mfc.api.request.cookie.PersistentCookieStore;
import com.ant_robot.mfc.api.request.json.DynamicJsonConverter;
import com.ant_robot.mfc.api.request.service.CollectionService;
import com.ant_robot.mfc.api.request.service.ConnexionService;
import com.ant_robot.mfc.api.request.service.GalleryService;
import com.ant_robot.mfc.api.request.service.ItemDate;
import com.ant_robot.mfc.api.request.service.ManageItemService;
import com.ant_robot.mfc.api.request.service.PostEndPoint;
import com.ant_robot.mfc.api.request.service.SearchService;
import com.ant_robot.mfc.api.request.service.UserService;
import com.squareup.okhttp.OkHttpClient;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;


public enum MFCRequest {
    INSTANCE;
    public static final String ROOT_URL = "http://myfigurecollection.net/api.php";
    public static final String LOGIN = "https://secure.myfigurecollection.net/signs.php";
    public static final String ITEM = "http://myfigurecollection.net/items.php";
    private final RestAdapter restAdapter;
    private final RestAdapter connectAdapter;
    private final RestAdapter galleryAdapter;

    private final OkHttpClient client;
    private final DynamicJsonConverter standartConverter;
    private List<HttpCookie> cookies;
    private final PostEndPoint poe;

    public enum MANAGECOLLECTION {
        NOTCONNECTED,
        OK,
        KO
    }

    public enum STATUS {
        WISHED(0), ORDERED(1), OWNED(2), DELETE(9);

        int method;

        STATUS(int i) {
            method = i;
        }

        public int toInt() {
            return method;
        }

        @Override
        public String toString() {
            return "" + method;
        }
    }


    public enum ROOT {
        FIGURES(0), GOODS(1), MEDIA(2);

        int method;

        ROOT(int i) {
            method = i;
        }

        public int toInt() {
            return method;
        }

        @Override
        public String toString() {
            return "" + method;
        }
    }

    public enum SHIPPING {
        NA(0), EMS(1), SAL(2), AIRMAIL(3), SURFACE(4), FEDEX(5), DHL(6), COLISSIMO(7), UPS(8), DOMESTIC(9);

        int method;

        SHIPPING(int i) {
            method = i;
        }

        public int toInt() {
            return method;
        }
    }

    public enum SUBSTATUS {
        NA(0), SECONDHAND(1), SEALED(2), STORE(3);

        int method;

        SUBSTATUS(int i) {
            method = i;
        }

        public int toInt() {
            return method;
        }
    }


    private MFCRequest() {
        client = new OkHttpClient();
        client.setConnectTimeout(60, TimeUnit.SECONDS);
        client.setReadTimeout(60, TimeUnit.SECONDS);
        client.setFollowRedirects(false);

        poe = new PostEndPoint(PostEndPoint.MODE.LOGIN);


        standartConverter = new DynamicJsonConverter();

        restAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setConverter(standartConverter)
                .setEndpoint(ROOT_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        galleryAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setConverter(standartConverter)
                .setEndpoint(ROOT_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        connectAdapter = new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(poe)
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

    public GalleryService getGalleryService() {
        return galleryAdapter.create(GalleryService.class);
    }

    public SearchService getSearchService() {
        return restAdapter.create(SearchService.class);
    }

    public UserService getUserService() {
        return restAdapter.create(UserService.class);
    }

    /**
     * Helper to send a connection request
     *
     * @param username the user login name
     * @param password the user password
     * @param context  an application context for the cookie store
     * @param callback calls success true if connection succeed, calls success false if everything went ok but connexion failed, calls failure otherwise
     */
    public void connect(String username, String password, final Context context, final Callback<Boolean> callback) {
        client.setCookieHandler(new CookieManager(
                new PersistentCookieStore(context),
                CookiePolicy.ACCEPT_ALL));

        connectAdapter.create(ConnexionService.class).connectUser(username, password, 1, "signin", "http://myfigurecollection.net/", new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {

                //Request went well, but MFC should return a HTTP 302 status if connection succeeded
                callback.success(checkCookies(context), response);
            }

            @Override
            public void failure(RetrofitError error) {

                switch (error.getKind()) {
                    case HTTP:
                        switch (error.getResponse().getStatus()) {
                            //if we have a HTTP 302 redirection with an empty body that means we logged in
                            case 302:
                                callback.success(checkCookies(context), error.getResponse());
                                break;

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

    /**
     * removes all connection cookies from the permanent cookie store
     *
     * @param context  an application context for the cookie store
     * @param callback calls success true if removal succeed, calls success false if something went wrong
     */
    public void disconnect(final Context context, final Callback<Boolean> callback) {
        PersistentCookieStore persistentCookieStore = new PersistentCookieStore(context);
        callback.success(persistentCookieStore.removeAll(), null);
    }

    public boolean checkCookies(Context context) {
        try {
            PersistentCookieStore persistentCookieStore = new PersistentCookieStore(context);

            cookies = persistentCookieStore.get(new URI("https://myfigurecollection.net/"));
        } catch (URISyntaxException e) {
            cookies = new ArrayList<>();
        }

        for (HttpCookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("tb_session_id")) {
                return true;
            }
        }
        return false;
    }

    public void orderFigure(String figureId, int number, double price, String where, SHIPPING method, String trackingNumber, ItemDate boughtDate, ItemDate shippingDate, SUBSTATUS substatus, STATUS previousStatus, Context context, final Callback<MANAGECOLLECTION> callback) {
        if (checkCookies(context)) {


            poe.setMode(PostEndPoint.MODE.ITEM);
            connectAdapter.create(ManageItemService.class).orderItem(figureId, "collect", STATUS.ORDERED.toInt(), number, price, where, method.toInt(), trackingNumber, boughtDate, shippingDate, substatus.toInt(), previousStatus.toInt(), 0, new Callback<AlterItem>() {
                @Override
                public void success(AlterItem alterItem, Response response) {
                    callback.success(MANAGECOLLECTION.OK, response);
                }

                @Override
                public void failure(RetrofitError error) {
                    callback.failure(error);
                }
            });

        } else {
            callback.success(MANAGECOLLECTION.NOTCONNECTED, null);
        }
    }

    public void ownFigure(String figureId, int number, ItemDate odate, int score, double price, String where, SHIPPING method, String trackingNumber, ItemDate boughtDate, ItemDate shippingDate, SUBSTATUS substatus, STATUS previousStatus, Context context, final Callback<MANAGECOLLECTION> callback) {
        if (checkCookies(context)) {


            poe.setMode(PostEndPoint.MODE.ITEM);
            connectAdapter.create(ManageItemService.class).ownItem(figureId, "collect", STATUS.OWNED.toInt(), number, score, odate, price, where, method.toInt(), trackingNumber, boughtDate, shippingDate, substatus.toInt(), previousStatus.toInt(), 0, new Callback<AlterItem>() {
                @Override
                public void success(AlterItem alterItem, Response response) {
                    callback.success(MANAGECOLLECTION.OK, response);
                }

                @Override
                public void failure(RetrofitError error) {
                    callback.failure(error);
                }
            });
        } else {
            callback.success(MANAGECOLLECTION.NOTCONNECTED, null);
        }
    }

    public void wishFigure(String figureId, int wishability, STATUS previousStatus, Context context, final Callback<MANAGECOLLECTION> callback) {
        if (checkCookies(context)) {


            poe.setMode(PostEndPoint.MODE.ITEM);
            connectAdapter.create(ManageItemService.class).wishItem(figureId, "collect", STATUS.WISHED.toInt(), wishability, previousStatus.toInt(), 0, new Callback<AlterItem>() {
                @Override
                public void success(AlterItem alterItem, Response response) {
                    callback.success(MANAGECOLLECTION.OK, response);
                }

                @Override
                public void failure(RetrofitError error) {
                    callback.failure(error);
                }
            });
        } else {
            callback.success(MANAGECOLLECTION.NOTCONNECTED, null);
        }
    }

    public void deleteFigure(String figureId, STATUS previousStatus, Context context, final Callback<MANAGECOLLECTION> callback) {
        if (checkCookies(context)) {


            poe.setMode(PostEndPoint.MODE.ITEM);
            connectAdapter.create(ManageItemService.class).deleteItem(figureId, "collect", STATUS.DELETE.toInt(), previousStatus.toInt(), 0, new Callback<AlterItem>() {
                @Override
                public void success(AlterItem alterItem, Response response) {
                    callback.success(MANAGECOLLECTION.OK, response);
                }

                @Override
                public void failure(RetrofitError error) {
                    callback.failure(error);
                }
            });
        } else {
            callback.success(MANAGECOLLECTION.NOTCONNECTED, null);
        }
    }


}
