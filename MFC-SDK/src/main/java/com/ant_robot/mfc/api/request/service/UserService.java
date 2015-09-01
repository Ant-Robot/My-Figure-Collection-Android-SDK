package com.ant_robot.mfc.api.request.service;


import com.ant_robot.mfc.api.pojo.UserProfile;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface UserService {
    @GET("/?mode=user&type=json")
    Observable<UserProfile> getUser(@Query("username") String username);

    @GET("/?mode=user&type=json")
    void getUser(@Query("username") String username, Callback<UserProfile> callback);

    @GET("/?mode=user&type=json")
    UserProfile getUserSync(@Query("username") String keywords);
}
