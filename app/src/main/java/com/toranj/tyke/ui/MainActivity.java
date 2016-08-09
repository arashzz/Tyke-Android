package com.toranj.tyke.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.toranj.tyke.R;
import com.toranj.tyke.TykeApp;
import com.toranj.tyke.dagger.components.ComponentProvider;
import com.toranj.tyke.dagger.components.DaggerComponentProvider;
import com.toranj.tyke.dagger.modules.FragmentModule;
import com.toranj.tyke.dagger.modules.LotteryModule;
import com.toranj.tyke.dagger.modules.SpendingModule;
import com.toranj.tyke.enums.DrawerItem;
import com.toranj.tyke.restApi.LotteryApiInterface;
import com.toranj.tyke.models.Lottery;
import com.toranj.tyke.ui.fragments.DashboardFragment;
import com.toranj.tyke.ui.fragments.listeners.DashboardFragmentListener;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
        implements DashboardFragmentListener, OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Toolbar toolbar;
    //private AccountHeader headerResult;
//    private Drawer result = null;
//    private CrossfadeDrawerLayout crossfadeDrawerLayout;
    private ComponentProvider componentProvider;

    @Inject
    FragmentManager fragmentManager;

    @Inject
    FragmentTransaction fragmentTransaction;

    @Override
    public void go() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        initializeActionBar();
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        //initializeDrawer(savedInstanceState);
//        FragmentComponent fragmentComponent = DaggerFragmentComponent.builder()
//                .fragmentModule(new FragmentModule(this))
//                .build();
//        fragmentComponent.inject(this);
        componentProvider = DaggerComponentProvider.builder()
                .networkComponent(((TykeApp)getApplication()).getNetworkComponent())
                .fragmentModule(new FragmentModule(this))
                .lotteryModule(new LotteryModule())
                .spendingModule(new SpendingModule())
                .build();
        componentProvider.inject(this);

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        fragmentTransaction.add(R.id.content_frame, dashboardFragment, "dashboardFragment");
        fragmentTransaction.commit();
//        ft.add(R.id.main_content_frame, aaa, "dashboardFragment");
//        ft.commit();
//        LotteryComponent lotteryComponent = DaggerLotteryComponent.builder()
//                .networkComponent(((TykeApp)getApplication()).getNetworkComponent())
//                .lotteryModule(new LotteryModule())
//                .build();
//        lotteryComponent.inject(this);
//
//        Call<List<Lottery>> call = LotteryApiInterface.getByCriteria("jermin");
//        call.enqueue(new Callback<List<Lottery>>() {
//
//            @Override
//            public void onResponse(Call<List<Lottery>> cll, Response<List<Lottery>> response) {
//                Log.d("test", "1");
//            }
//
//            @Override
//            public void onFailure(Call<List<Lottery>> cll, Throwable t) {
//                Log.d("test", "2");
//            }
//        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        //outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        //outState = headerResult.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
//        if (result != null && (result.isDrawerOpen() || result.getMiniDrawer().getDrawer().isDrawerOpen())) {
//            result.closeDrawer();
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actions, menu);
        return true;
    }
//
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        if(drawerToggle != null) {
            drawerToggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void initializeDrawer(Bundle savedInstance) {
//        final IProfile profile = new ProfileDrawerItem()
//                .withName("آرش معین جهرمی")
//                .withEmail("arash@gmail.com")
//                .withIcon(R.drawable.userprofile);
//
//        headerResult = new AccountHeaderBuilder()
//                .withActivity(this)
////                .withHeaderBackground(R.drawable.header)
//                .withHeaderBackground(R.color.colorPrimary)
//                .addProfiles(profile)
//                .withSavedInstance(savedInstance)
//                .build();
//
//        result = new DrawerBuilder()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withHasStableIds(true)
//                .withDrawerLayout(R.layout.crossfade_drawer)
//                .withDrawerWidthDp(72)
//                .withDelayOnDrawerClose(150)
//                .withDelayDrawerClickEvent(150)
//                .withGenerateMiniDrawer(true)
//                .withAccountHeader(headerResult)
//                .addDrawerItems(
//                        new PrimaryDrawerItem()
//                                .withName("داشبورد")
//                                .withIcon(R.drawable.ic_home_black_36dp)
//                                .withIdentifier(1)
//                                .withSelectable(true)
//                                .withTag(DrawerItem.DRAWER_HOME),
//                        new PrimaryDrawerItem()
//                                .withName("حساب کاربری")
//                                .withIcon(R.drawable.ic_account_box_black_36dp)
//                                .withIdentifier(2)
//                                .withTag(DrawerItem.DRAWER_ACCOUNT),
//                        new PrimaryDrawerItem()
//                                .withName("لاتاری ها")
//                                .withIcon(R.drawable.ic_card_membership_black_36dp)
//                                .withIdentifier(3)
//                                .withTag(DrawerItem.DRAWER_MEMBERSHIP),
//                        new PrimaryDrawerItem()
//                                .withName("Dashboard")
//                                .withIcon(R.drawable.ic_redeem_black_36dp)
//                                .withIdentifier(4)
//                                .withTag(DrawerItem.DRAWER_REDEEM)
//                )
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
//                        if (drawerItem instanceof Nameable) {
//                            DrawerItem tag = (DrawerItem)drawerItem.getTag();
//                            String name = "";
//                            if(tag == DrawerItem.DRAWER_ACCOUNT) {
//                                name = "account";
//                            }
//                            else if(tag == DrawerItem.DRAWER_HOME) {
//                                name = "home";
//                            }
//                            else if(tag == DrawerItem.DRAWER_MEMBERSHIP) {
//                                name = "membership";
//                            }
//                            else if(tag == DrawerItem.DRAWER_REDEEM) {
//                                name = "redeem";
//                            }
//                            Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
//                        }
//                        //we do not consume the event and want the Drawer to continue with the event chain
//                        result.closeDrawer();
//                        return false;
//                    }
//                })
//                .withSavedInstance(savedInstance)
//                .withShowDrawerOnFirstLaunch(true)
//                .build();
//
//
//        crossfadeDrawerLayout = (CrossfadeDrawerLayout)result.getDrawerLayout();
//        crossfadeDrawerLayout.setMaxWidthPx(DrawerUIUtils.getOptimalDrawerWidth(this));
//
//        final MiniDrawer miniResult = result.getMiniDrawer();
//        View view = miniResult.build(this);
//        view.setBackgroundColor(
//                UIUtils.getThemeColorFromAttrOrRes(
//                        this,
//                        com.mikepenz.materialdrawer.R.attr.material_drawer_background,
//                        //com.mikepenz.materialdrawer.R.color.material_drawer_background
//                        R.color.colorPrimaryDark));
//        crossfadeDrawerLayout.getSmallView().addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        miniResult.withCrossFader(new ICrossfader() {
//            @Override
//            public void crossfade() {
//                boolean isFaded = isCrossfaded();
//                crossfadeDrawerLayout.crossfade(400);
//
//                //only close the drawer if we were already faded and want to close it now
//                if (isFaded) {
//                    result.getDrawerLayout().closeDrawer(GravityCompat.START);
//                }
//            }
//
//            @Override
//            public boolean isCrossfaded() {
//                return crossfadeDrawerLayout.isCrossfaded();
//            }
//        });
    }

    private void initializeActionBar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemIconTintList(null);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar ,  R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

                //getActionBar().setTitle(mTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
//        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setTitle("Arash");
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if(!item.isChecked()) {
            item.setChecked(true);
        }
        drawerLayout.closeDrawers();

        switch(item.getItemId()) {

        }
        return true;
    }
}
