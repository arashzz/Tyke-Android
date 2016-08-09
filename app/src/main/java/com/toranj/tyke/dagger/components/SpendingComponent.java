package com.toranj.tyke.dagger.components;

import com.toranj.tyke.dagger.modules.SpendingModule;
import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.restApi.SpendingApiInterface;
import com.toranj.tyke.ui.fragments.DashboardFragment;

import dagger.Component;

/**
 * Created by arash on 8/5/16.
 */

//@PerActivity
//@Component( dependencies = NetworkComponent.class, modules = SpendingModule.class )
public interface SpendingComponent {
    void inject(DashboardFragment fragment);

    SpendingApiInterface spendingApiInterface();
}
