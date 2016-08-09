package com.toranj.tyke.dagger.components;

import com.toranj.tyke.dagger.modules.LotteryModule;
import com.toranj.tyke.dagger.modules.SpendingModule;
import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.restApi.LotteryApiInterface;
import com.toranj.tyke.restApi.SpendingApiInterface;
import com.toranj.tyke.ui.MainActivity;
import com.toranj.tyke.ui.fragments.DashboardFragment;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by arash on 7/25/16.
 */

//@PerActivity
//@Component(dependencies = NetworkComponent.class,
//        modules = {
//                LotteryModule.class,
//                SpendingModule.class
//        })
public interface LotteryComponent {
    void inject(DashboardFragment fragment);

    LotteryApiInterface lotteryApiInterface();
    SpendingApiInterface spendingApiInterface();
}
