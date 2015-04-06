package com.ant_robot.mfc.api.request.service;

import com.ant_robot.mfc.api.pojo.SearchResult;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Search service results are limited to 20 items
 */
public interface SearchService {
    @GET("/?mode=search&type=json")
    Observable<SearchResult> search(@Query("keywords") String keywords);

    @GET("/?mode=search&type=json")
    void search(@Query("keywords") String keywords, Callback<SearchResult> callback);

    @GET("/?mode=search&type=json")
    SearchResult searchSync(@Query("keywords") String keywords);
}
