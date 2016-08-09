package com.toranj.tyke;

import android.app.Application;

import com.toranj.tyke.dagger.components.DaggerNetworkComponent;
import com.toranj.tyke.dagger.components.LotteryComponent;
import com.toranj.tyke.dagger.components.NetworkComponent;
import com.toranj.tyke.dagger.modules.AppModule;
import com.toranj.tyke.dagger.modules.LotteryModule;
import com.toranj.tyke.dagger.modules.NetworkModule;
import com.toranj.tyke.support.FontsOverride;

/**
 * Created by arash on 7/25/16.
 */
public class TykeApp extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        FontsOverride.setDefaultFont(this, "DEFAULT", "iransans.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "iransans.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "iransans.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "iransans.ttf");

        networkComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("http://192.168.0.4:8080"))
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
