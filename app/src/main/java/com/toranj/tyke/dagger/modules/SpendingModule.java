package com.toranj.tyke.dagger.modules;

import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.restApi.SpendingApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by arash on 8/5/16.
 */

@Module
public class SpendingModule {

    @Provides
    @PerActivity
    public SpendingApiInterface providesSpendingApiInterface(Retrofit retrofit) {
        return retrofit.create(SpendingApiInterface.class);
    }
}
