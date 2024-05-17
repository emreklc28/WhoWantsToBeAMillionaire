package com.emrekilic.whowantstobeamillionaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emrekilic.whowantstobeamillionaire.model.AnswerModel;

import java.util.List;

public class AdapterQuestions extends RecyclerView.Adapter<AdapterQuestions.QuestionsHolder> {

    List<AnswerModel> answerModelList;
    private AnswerModel checkedAnswer;

    public void setAnswerModelList(List<AnswerModel> answerModelList){
        this.answerModelList=answerModelList;
        notifyDataSetChanged();
    }

    Context mContext;
    public AdapterQuestions(Context mContext) {
        this.mContext=mContext;
        notifyDataSetChanged();
    }

    public AnswerModel getCheckedAnswer() {
        return checkedAnswer;
    }

    @NonNull
    @Override
    public QuestionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.questions_row,parent,false);
        return new QuestionsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsHolder holder, int position) {

        AnswerModel model = answerModelList.get(position);

        if (model.isSelected()) {
            //backround
        } else {

        }

        holder.answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                checkedAnswer = answerModelList.get(position);

                for (AnswerModel model : answerModelList) {
                    if (i == position) {
                        model.setSelected(true);
                    } else {
                        model.setSelected(false);
                    }
                    i++;
                }
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class QuestionsHolder extends RecyclerView.ViewHolder{

        TextView text_questions,answer1,answer2,answer3,answer4,time_text_view;
        ImageView cift_cevap_joker,yuzde_elli_joker;
        ProgressBar progress_bar_counter;


        public QuestionsHolder(@NonNull View itemView) {
            super(itemView);

            text_questions=itemView.findViewById(R.id.text_questions);
            answer1=itemView.findViewById(R.id.answer_1);
            answer2=itemView.findViewById(R.id.answer_2);
            answer3=itemView.findViewById(R.id.answer_3);
            answer4=itemView.findViewById(R.id.answer_4);
            time_text_view=itemView.findViewById(R.id.time_text_view);
            cift_cevap_joker=itemView.findViewById(R.id.cift_cevap_joker);
            yuzde_elli_joker=itemView.findViewById(R.id.yuzde_elli_joker);
            progress_bar_counter=itemView.findViewById(R.id.progress_bar_counter);



        }
    }
}
