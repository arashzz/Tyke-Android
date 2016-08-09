package com.toranj.tyke.restApi;

import com.toranj.tyke.models.Spending;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by arash on 8/5/16.
 */
public interface SpendingApiInterface {

    @GET("/spending/expired")
    Call<Spending> getExpired(@Query("username") String username);
}
