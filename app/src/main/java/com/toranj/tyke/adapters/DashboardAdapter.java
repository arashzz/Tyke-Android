package com.toranj.tyke.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.toranj.tyke.R;
import com.toranj.tyke.models.Lottery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arash on 7/28/16.
 */
public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.AdapterViewHolder> {
    private List<Lottery> lotteryList;

    public DashboardAdapter(List<Lottery> lotteryList) {
        this.lotteryList = new ArrayList<>();
        if(lotteryList != null) {
            this.lotteryList = lotteryList;
        }
    }

    public void addItems(List<Lottery> lotteryList) {
        if(this.lotteryList == null) {
            this.lotteryList = new ArrayList<>();
        }
        if(lotteryList != null) {
            this.lotteryList.addAll(lotteryList);
            notifyDataSetChanged();
        }
    }

    public void addItem(Lottery lottery) {
        if(lotteryList == null) {
            this.lotteryList = new ArrayList<>();
        }
        lotteryList.add(lottery);
        notifyDataSetChanged();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_lottery, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        Lottery lottery = lotteryList.get(position);
        holder.name.setText(lottery.getName());
    }

    @Override
    public int getItemCount() {
        return lotteryList.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public AdapterViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }
}
