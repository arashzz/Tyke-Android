package com.toranj.tyke.dagger.modules;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.toranj.tyke.dagger.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by arash on 8/2/16.
 */

@Module
public class FragmentModule {

    AppCompatActivity activity;

    public FragmentModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public FragmentManager providesFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @PerActivity
    public FragmentTransaction providesFragmentTransaction(FragmentManager fm) {
        return activity.getSupportFragmentManager().beginTransaction();
        //return fm.beginTransaction();
    }
}
