package com.toranj.tyke.restApi;

import com.toranj.tyke.models.Lottery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arash on 7/26/16.
 */

public interface LotteryApiInterface {
    @GET("/lottery/search")
    Call<List<Lottery>> getByCriteria(@Query("q") String query);

    @GET("lottery/details")
    Call<Lottery> getById(@Query("Id") String id);
}
