package com.toranj.tyke.dagger.components;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.toranj.tyke.dagger.modules.FragmentModule;
import com.toranj.tyke.dagger.modules.LotteryModule;
import com.toranj.tyke.dagger.modules.SpendingModule;
import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.restApi.LotteryApiInterface;
import com.toranj.tyke.restApi.SpendingApiInterface;
import com.toranj.tyke.ui.MainActivity;
import com.toranj.tyke.ui.fragments.DashboardFragment;

import dagger.Component;

/**
 * Created by arash on 8/5/16.
 */

@PerActivity
@Component(
        dependencies = NetworkComponent.class,
        modules = {
                LotteryModule.class,
                SpendingModule.class,
                FragmentModule.class
        }
)
public interface ComponentProvider {
    void inject(DashboardFragment fragment);
    void inject(MainActivity activity);

    LotteryApiInterface lotteryApiInterface();
    SpendingApiInterface spendingApiInterface();
    FragmentManager fragmentManager();
    FragmentTransaction transaction();
}
