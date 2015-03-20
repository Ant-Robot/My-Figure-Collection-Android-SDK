package com.ant_robot.mfc.api.request;

import com.ant_robot.mfc.api.pojo.UserCollection;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by e0000429 on 20/03/2015.
 */
public interface CollectionService {

    public enum STATUS {
        WISHED {
            @Override
            public String toString() {
                return STATUS_WISHED;
            }
        }, ORDERED {
            @Override
            public String toString() {
                return STATUS_ORDERED;
            }
        }, OWNED {
            @Override
            public String toString() {
                return STATUS_OWNED;
            }
        }
    }

    ;

    public enum ROOT {
        FIGURES {
            @Override
            public String toString() {
                return ROOT_FIGURES;
            }
        }, GOODS {
            @Override
            public String toString() {
                return ROOT_GOODS;
            }
        }, MEDIA {
            @Override
            public String toString() {
                return ROOT_MEDIA;
            }
        }
    }

    ;

    static final String STATUS_WISHED = "0";
    static final String STATUS_ORDERED = "1";
    static final String STATUS_OWNED = "2";

    static final String ROOT_FIGURES = "0";
    static final String ROOT_GOODS = "1";
    static final String ROOT_MEDIA = "2";

    @GET("/?mode=collection&type=json")
    Observable<UserCollection> getCollection(@Query("username") String userName);

    @GET("/?mode=collection&type=json")
    Observable<UserCollection> getCollection(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    Observable<UserCollection> getWished(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_WISHED)
    Observable<UserCollection> getWished(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status" + STATUS_ORDERED)
    Observable<UserCollection> getOrdered(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status" + STATUS_ORDERED)
    Observable<UserCollection> getOrdered(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    Observable<UserCollection> getOwned(@Query("username") String userName);

    @GET("/?mode=collection&type=json&status=" + STATUS_OWNED)
    Observable<UserCollection> getOwned(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    Observable<UserCollection> getFigures(@Query("username") String userName, @Query("page") int page);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    Observable<UserCollection> getGoods(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    Observable<UserCollection> getMedia(@Query("username") String userName, @Query("page") byte page);

    @GET("/?mode=collection&type=json&root=" + ROOT_FIGURES)
    Observable<UserCollection> getFigures(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_GOODS)
    Observable<UserCollection> getGoods(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);

    @GET("/?mode=collection&type=json&root=" + ROOT_MEDIA)
    Observable<UserCollection> getMedia(@Query("username") String userName, @Query("page") byte page, @Query("status") String status);


}
