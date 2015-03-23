package com.ant_robot.mfc.api.request.service;


import com.ant_robot.mfc.api.pojo.PictureGallery;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Returned items are limited to 20 but you can access full galleries by modifying the page param.
 */
public interface GalleryService {
    @GET("/?mode=gallery&type=json")
    Observable<PictureGallery> getGalleryForUser(@Query("username") String username, @Query("page") int page);

    @GET("/?mode=gallery&type=json")
    void getGalleryForUser(@Query("username") String username, @Query("page") int page, Callback<PictureGallery> callback);

    @GET("/?mode=gallery&type=json")
    PictureGallery getGalleryForUserSync(@Query("username") String keywords, @Query("page") int page);

    @GET("/?mode=gallery&type=json")
    Observable<PictureGallery> getGalleryForItem(@Query("item") String itemId, @Query("page") int page);

    @GET("/?mode=gallery&type=json")
    void getGalleryForItem(@Query("item") String itemId, @Query("page") int page, Callback<PictureGallery> callback);

    @GET("/?mode=gallery&type=json")
    PictureGallery getGalleryForItemSync(@Query("item") String itemId, @Query("page") int page);
}
