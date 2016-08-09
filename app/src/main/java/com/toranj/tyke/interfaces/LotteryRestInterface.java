package com.toranj.tyke.interfaces;

import com.toranj.tyke.models.Lottery;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arash on 7/24/16.
 */
public interface LotteryRestInterface {
    @GET("/lottery/search")
    Call<List<Lottery>> getList(@Query("q") String queue);
}
