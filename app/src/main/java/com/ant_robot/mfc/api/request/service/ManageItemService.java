package com.ant_robot.mfc.api.request.service;

import com.ant_robot.mfc.api.pojo.AlterItem;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * unofficial service to manage collection
 * e.g: commit=collect&status=1&num=1&value=52.0&location=AmiAmi&method=0&track=&bdate=0000-00-00&sdate=0000-00-00&sub_status=1&previous_status=1&reload=0
 */
public interface ManageItemService {

    /**
     * @param itemId          item id
     * @param commit          set value "collect" for the collection
     * @param status          new status in collection (0,1,2)
     * @param num             number in collection for this status
     * @param value           price you bought item
     * @param location        shop where you bought item
     * @param method          shipping method (0:N/A, 1:EMS, 2:SAL, 3:AIRMAIL, 4:SURFACE, 5:FEDEX, 6:DHL, 7:COLISSIMO, 8:UPS, 9:DOMESTIC)
     * @param track           tracking number
     * @param bdate           order date
     * @param sdate           shipping date
     * @param sub_status      0:N/A, 1: second hand, 2:Sealed, 3:stored
     * @param previous_status the current status in collection
     * @param reload          unknown effect, prefer a 0 value
     * @param callback        to manage request response
     */
    @FormUrlEncoded
    @Headers({
            "User-Agent: MFC Android app",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/")
    void alterItem(@Query("iid") String itemId,
                   @Field("commit") String commit,
                   @Field("status") String status,
                   @Field("num") int num,
                   @Field("value") double value,
                   @Field("location") String location,
                   @Field("method") String method,
                   @Field("track") String track,
                   @Field("bdate") String bdate,
                   @Field("sdate") String sdate,
                   @Field("sub_status") String sub_status,
                   @Field("previous_status") String previous_status,
                   @Field("reload") int reload, Callback<AlterItem> callback);

    /**
     * @param itemId          item id
     * @param commit          set value "collect" for the collection
     * @param status          new status in collection (0,1,2)
     * @param num             number in collection for this status
     * @param value           price you bought item
     * @param location        shop where you bought item
     * @param method          shipping method (0:N/A, 1:EMS, 2:SAL, 3:AIRMAIL, 4:SURFACE, 5:FEDEX, 6:DHL, 7:COLISSIMO, 8:UPS, 9:DOMESTIC)
     * @param track           tracking number
     * @param bdate           order date
     * @param sdate           shipping date
     * @param sub_status      0:N/A, 1: second hand, 2:Sealed, 3:stored
     * @param previous_status the current status in collection
     * @param reload          unknown effect, prefer a 0 value
     */
    @FormUrlEncoded
    @Headers({
            "User-Agent: MFC Android app",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/")
    AlterItem alterItemSync(@Query("iid") String itemId,
                            @Field("commit") String commit,
                            @Field("status") String status,
                            @Field("num") int num,
                            @Field("value") double value,
                            @Field("location") String location,
                            @Field("method") String method,
                            @Field("track") String track,
                            @Field("bdate") String bdate,
                            @Field("sdate") String sdate,
                            @Field("sub_status") String sub_status,
                            @Field("previous_status") String previous_status,
                            @Field("reload") int reload);


    /**
     * @param itemId          item id
     * @param commit          set value "collect" for the collection
     * @param status          new status in collection (0,1,2)
     * @param num             number in collection for this status
     * @param value           price you bought item
     * @param location        shop where you bought item
     * @param method          shipping method (0:N/A, 1:EMS, 2:SAL, 3:AIRMAIL, 4:SURFACE, 5:FEDEX, 6:DHL, 7:COLISSIMO, 8:UPS, 9:DOMESTIC)
     * @param track           tracking number
     * @param bdate           order date
     * @param sdate           shipping date
     * @param sub_status      0:N/A, 1: second hand, 2:Sealed, 3:stored
     * @param previous_status the current status in collection
     * @param reload          unknown effect, prefer a 0 value
     */
    @FormUrlEncoded
    @Headers({
            "User-Agent: MFC Android app",
            "Accept-Language: fr,fr-FR;q=0.8,en;q=0.6,en-US;q=0.4,es;q=0.2,ja;q=0.2",
            "Connection: keep-alive"
    }
    )
    @POST("/")
    Observable<AlterItem> alterItem(@Query("iid") String itemId,
                                    @Field("commit") String commit,
                                    @Field("status") String status,
                                    @Field("num") int num,
                                    @Field("value") double value,
                                    @Field("location") String location,
                                    @Field("method") String method,
                                    @Field("track") String track,
                                    @Field("bdate") String bdate,
                                    @Field("sdate") String sdate,
                                    @Field("sub_status") String sub_status,
                                    @Field("previous_status") String previous_status,
                                    @Field("reload") int reload);
}
