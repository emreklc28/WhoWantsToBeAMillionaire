package com.emrekilic.whowantstobeamillionaire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterQuestions extends RecyclerView.Adapter<AdapterQuestions.QuestionsHolder> {

    @NonNull
    @Override
    public QuestionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_row,parent,false);
        return new com.emrekilic.whowantstobeamillionaire.AdapterQuestions.QuestionsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class QuestionsHolder extends RecyclerView.ViewHolder{


        public QuestionsHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
