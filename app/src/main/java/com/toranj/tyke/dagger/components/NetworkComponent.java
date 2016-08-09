package com.toranj.tyke.dagger.components;

import android.content.SharedPreferences;

import com.toranj.tyke.dagger.modules.AppModule;
import com.toranj.tyke.dagger.modules.NetworkModule;
import com.toranj.tyke.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by arash on 7/24/16.
 */

@Singleton
@Component(modules = { AppModule.class, NetworkModule.class })
public interface NetworkComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
