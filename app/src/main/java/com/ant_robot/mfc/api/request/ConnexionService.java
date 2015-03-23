package com.ant_robot.mfc.api.request;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by climbatize on 20/03/15.
 */
public interface ConnexionService {
    @FormUrlEncoded
    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "User-Agent: MFC Android app",
            "Cache-Control: max-age=0",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/?mode=in&ln=en")
    void connectUser(@Field("username") String name, @Field("password") String pass, @Field("set_cookie") int cookie, @Field("commit") String commit, @Field("location") String location, Callback<Response> callback);

    @FormUrlEncoded
    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "User-Agent: MFC Android app",
            "Cache-Control: max-age=0",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/?mode=in&ln=en")
    Response connectUserSync(@Field("username") String name, @Field("password") String pass, @Field("set_cookie") int cookie, @Field("commit") String commit, @Field("location") String location);

    @FormUrlEncoded
    @Headers({
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "User-Agent: MFC Android app",
            "Cache-Control: max-age=0",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/?mode=in&ln=en")
    Observable<Response> connectUser(@Field("username") String name, @Field("password") String pass, @Field("set_cookie") int cookie, @Field("commit") String commit, @Field("location") String location);
}
