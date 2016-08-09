package com.toranj.tyke.dagger.components;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.toranj.tyke.dagger.modules.FragmentModule;
import com.toranj.tyke.dagger.scopes.PerActivity;
import com.toranj.tyke.ui.MainActivity;

import dagger.Component;

/**
 * Created by arash on 8/2/16.
 */

//@PerActivity
//@Component(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(MainActivity activity);

    FragmentManager fragmentManager();
    FragmentTransaction fragmentTransaction();
}
