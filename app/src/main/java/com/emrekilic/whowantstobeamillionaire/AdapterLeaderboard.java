package com.emrekilic.whowantstobeamillionaire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterLeaderboard extends RecyclerView.Adapter<AdapterLeaderboard.LeaderboardHolder> {

    @NonNull
    @Override
    public LeaderboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_page,parent,false);
        return new LeaderboardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LeaderboardHolder extends RecyclerView.ViewHolder{

        public LeaderboardHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
