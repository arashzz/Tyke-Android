package com.toranj.tyke.dagger.modules;

import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.models.Lottery;
import com.toranj.tyke.restApi.LotteryApiInterface;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arash on 7/25/16.
 */

@Module
public class LotteryModule {

    @Provides
    @PerActivity
    public LotteryApiInterface providesLotteryApiInterface(Retrofit retrofit) {
        return retrofit.create(LotteryApiInterface.class);
    }
}
