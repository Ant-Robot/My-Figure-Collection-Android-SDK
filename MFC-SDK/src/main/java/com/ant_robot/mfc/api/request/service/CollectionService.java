package com.ant_robot.mfc.api.request.service;

import com.ant_robot.mfc.api.pojo.ItemList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 *
 * Returned items are limited to 50 but you can access full collections by modifying the page param.
 *
 */
public interface CollectionService {


    static final String STATUS_WISHED = "0";
    static final String STATUS_ORDERED = "1";
    static final String STATUS_OWNED = "2";

    static final String ROOT_FIGURES = "0";
    static final String ROOT_GOODS = "1";
    static final String ROOT_MEDIA = "2";

    @GET("/?mode=collection&type=json")
    Observable<ItemList> getCollection(@Query("username") String userName);

    @GET("/?mode=collection&type=json")
    void getCollection(@Query("username") String userName, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json")
    ItemList getCollectionSync(@Query("username") String userName);

    @GET("/?mode=collection&type=json")
    Observable<ItemList> getCollection(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json")
    void getCollection(@Query("username") String userName, @Query("page") int page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json")
    ItemList getCollectionSync(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json")
    Observable<ItemList> getCollection(@Query("username") String userName, @Query("page") int page, @Query("status") int status, @Query("root") int root);

    @GET("/?mode=collection&type=json")
    void getCollection(@Query("username") String userName, @Query("page") int page, @Query("status") int status, @Query("root") int root, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json")
    ItemList getCollectionSync(@Query("username") String userName, @Query("page") int page, @Query("status") int status, @Query("root") int root);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    Observable<ItemList> getWished(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    void getWished(@Query("username") String userName, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    ItemList getWishedSync(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    Observable<ItemList> getWished(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    void getWished(@Query("username") String userName, @Query("page") int page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    ItemList getWishedSync(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_ORDERED)
    Observable<ItemList> getOrdered(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_ORDERED)
    void getOrdered(@Query("username") String userName, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_ORDERED)
    ItemList getOrderedSync(@Query("username") String userName);

    @GET("/?mode=collection&type=json&statu=s" + STATUS_ORDERED)
    Observable<ItemList> getOrdered(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_ORDERED)
    void getOrdered(@Query("username") String userName, @Query("page") int page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_ORDERED)
    ItemList getOrderedSync(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    Observable<ItemList> getOwned(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    void getOwned(@Query("username") String userName, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    ItemList getOwnedSync(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    Observable<ItemList> getOwned(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    void getOwned(@Query("username") String userName, @Query("page") int page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    ItemList getOwnedSync(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    Observable<ItemList> getFigures(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    void getFigures(@Query("username") String userName, @Query("page") int page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    ItemList getFiguresSync(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    Observable<ItemList> getGoods(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    void getGoods(@Query("username") String userName, @Query("page") byte page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    ItemList getGoodsSync(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    Observable<ItemList> getMedia(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    void getMedia(@Query("username") String userName, @Query("page") byte page, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    ItemList getMediaSync(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    Observable<ItemList> getFigures(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    void getFigures(@Query("username") String userName, @Query("page") byte page, @Query("status") String status, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    ItemList getFiguresSync(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    Observable<ItemList> getGoods(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    void getGoods(@Query("username") String userName, @Query("page") byte page, @Query("status") String status, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    ItemList getGoodsSync(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    Observable<ItemList> getMedia(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    void getMedia(@Query("username") String userName, @Query("page") byte page, @Query("status") String status, Callback<ItemList> callback);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    ItemList getMediaSync(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);


}
