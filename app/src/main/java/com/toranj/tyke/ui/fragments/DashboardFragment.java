package com.toranj.tyke.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toranj.tyke.R;
import com.toranj.tyke.TykeApp;
import com.toranj.tyke.adapters.DashboardAdapter;
import com.toranj.tyke.dagger.components.ComponentProvider;
import com.toranj.tyke.dagger.components.DaggerComponentProvider;
import com.toranj.tyke.dagger.modules.FragmentModule;
import com.toranj.tyke.dagger.modules.LotteryModule;
import com.toranj.tyke.dagger.modules.SpendingModule;
import com.toranj.tyke.models.Lottery;
import com.toranj.tyke.models.Spending;
import com.toranj.tyke.restApi.LotteryApiInterface;
import com.toranj.tyke.restApi.SpendingApiInterface;
import com.toranj.tyke.ui.MainActivity;
import com.toranj.tyke.ui.fragments.listeners.DashboardFragmentListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.toranj.tyke.retrofit.TykeCallback;
import com.toranj.tyke.retrofit.TykeCallbackResponse;
import retrofit2.Call;
import retrofit2.Retrofit;

public class DashboardFragment extends Fragment {

    private DashboardFragmentListener activityListener;
    private RecyclerView recyclerView;
    private DashboardAdapter dashboardAdapter;
    private ComponentProvider componentProvider;

    private SpendingCallback spendingCallback;
    private LotteryCallback lotteryCallback;

    @Inject
    Retrofit retrofit;

    @Inject
    LotteryApiInterface lotteryApiInterface;

    @Inject
    SpendingApiInterface spendingApiInterface;

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        go();
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        view.invalidate();
        initializeViewComponents(view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity != null) {
            try {
                activityListener = (DashboardFragmentListener) activity;
            }
            catch(ClassCastException e) {
                Log.e("DashboardFragment", "The Activity passed is not an Instance of DashboardFragmentListener Interface");
            }

            initComponents();

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activityListener = null;
    }

    private void initComponents() {
//        lotteryComponent = DaggerLotteryComponent.builder()
//                .networkComponent(((TykeApp)getActivity().getApplication()).getNetworkComponent())
//                .lotteryModule(new LotteryModule())
//                .build();
//        lotteryComponent.inject(this);
        componentProvider = DaggerComponentProvider.builder()
                .networkComponent(((TykeApp)getActivity().getApplication()).getNetworkComponent())
                .fragmentModule(new FragmentModule((MainActivity)getActivity()))
                .lotteryModule(new LotteryModule())
                .spendingModule(new SpendingModule())
                .build();
        componentProvider.inject(this);
    }

    private void initializeViewComponents(View view) {
        //RecyclerView initialization
        recyclerView = (RecyclerView)view.findViewById(R.id.lotteries_recycler);

        //Adapter for RecyclerView
        dashboardAdapter = new DashboardAdapter(new ArrayList<Lottery>());
        recyclerView.setAdapter(dashboardAdapter);

        final GridLayoutManager lm = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        //final LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(lm);


        List<Lottery> result = new ArrayList<>();
        Lottery lottery1 = new Lottery();
        lottery1.setName("روز پدر");
        result.add(lottery1);
        Lottery lottery2 = new Lottery();
        lottery2.setName("شب نشینی");
        result.add(lottery2);
        Lottery lottery3 = new Lottery();
        lottery3.setName("روز مادر");
        result.add(lottery3);
        Lottery lottery = new Lottery();
        lottery.setName("عید نوروز");
        result.add(lottery);
        Lottery lottery5 = new Lottery();
        lottery5.setName("ماه رمدون ۲");
        result.add(lottery5);
        Lottery lottery6 = new Lottery();
        lottery6.setName("الکی پلکی");
        result.add(lottery6);
        Lottery lottery7 = new Lottery();
        lottery7.setName("پول زور بده");
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);
        result.add(lottery7);

        dashboardAdapter.addItems(result);

    }

    private void populateLotteries(List<Lottery> lotteris) {
        dashboardAdapter.addItems(lotteris);
    }

    private void populateSpending(Spending spending) {

    }

    private void go() {

        Call<List<Lottery>> lotteryListCall = lotteryApiInterface.getByCriteria("jermin");
        lotteryListCall.enqueue(new TykeCallback<List<Lottery>>(new LotteryCallback()));

        Call<Spending> expiredSpendingCall = spendingApiInterface.getExpired("arash.moeen");
        expiredSpendingCall.enqueue(new TykeCallback<Spending>(new SpendingCallback()));

        //Call<Spending> call =
//        Call<List<Lottery>> call = lotteryApiInterface.getByCriteria("jermin");
//        call.enqueue(new TykeCallback<List<Lottery>>(this));
        //listener.go();
    }

    public class SpendingCallback implements TykeCallbackResponse<Spending> {
        @Override
        public void onResponse(Spending result) {
            populateSpending(result);
        }

        @Override
        public void onFailure() {

        }
    }


    public class LotteryCallback implements TykeCallbackResponse<List<Lottery>> {
        @Override
        public void onResponse(List<Lottery> result) {
            populateLotteries(result);
        }

        @Override
        public void onFailure() {

        }
    }
}
