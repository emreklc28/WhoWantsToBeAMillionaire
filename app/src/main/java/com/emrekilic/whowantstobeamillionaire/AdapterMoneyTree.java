package com.emrekilic.whowantstobeamillionaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterMoneyTree extends RecyclerView.Adapter<AdapterMoneyTree.MoneyTreeHolder> {

    public AdapterMoneyTree() {

    }

    @NonNull
    @Override
    public MoneyTreeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.money_tree_row,parent,false);
        return new MoneyTreeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoneyTreeHolder holder, int position) {
        holder.text_money.setText("200TL");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MoneyTreeHolder extends RecyclerView.ViewHolder{

        TextView text_money;


        public MoneyTreeHolder(@NonNull View itemView) {
            super(itemView);
            text_money=itemView.findViewById(R.id.text_money);

        }


    }
}
