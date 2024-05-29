package com.emrekilic.whowantstobeamillionaire;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emrekilic.whowantstobeamillionaire.model.AnswerModel;

import java.util.List;

public class AdapterQuestions extends RecyclerView.Adapter<AdapterQuestions.QuestionsHolder> {

    List<AnswerModel> answerModelList;
    private AnswerModel checkedAnswer;
    Answer answer;





    public void setAnswerModelList(List<AnswerModel> answerModelList){
        this.answerModelList=answerModelList;
        notifyDataSetChanged();
    }

    public void setAnswer(Answer answer){
        this.answer=answer;
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

    public Answer getAnser(){
        Toast.makeText(mContext, "Tıklandı", Toast.LENGTH_SHORT).show();
        return answer;
    }

    @NonNull
    @Override
    public QuestionsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_row,parent,false);
        return new QuestionsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsHolder holder, @SuppressLint("RecyclerView") int position) {

        AnswerModel model = answerModelList.get(position);
        holder.answer1.setText(answerModelList.get(position).getQuestion());

        if (model.isSelected()) {
            holder.answer1.setBackgroundResource(R.drawable.clicked_answer);
            holder.imageView1.setVisibility(View.GONE);
            holder.imageView2.setVisibility(View.VISIBLE);
            

        } else {
            holder.answer1.setBackgroundResource(R.drawable.text_view_rectangle_answers);
            holder.imageView1.setVisibility(View.VISIBLE);
            holder.imageView2.setVisibility(View.GONE);
        }

        holder.answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = 0;
                checkedAnswer = answerModelList.get(position);

                for (AnswerModel model : answerModelList) {
                    if (i == position) {

                        model.setSelected(true);

                        holder.answer1.setText(answerModelList.get(position).getQuestion());


                        if (model.isCorrectAnswer()){

                        }


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
        return answerModelList.size();
    }

    public static class QuestionsHolder extends RecyclerView.ViewHolder{

        TextView answer1;

        ImageView imageView1,imageView2;


        public QuestionsHolder(@NonNull View itemView) {
            super(itemView);

            answer1=itemView.findViewById(R.id.answer_1);
            imageView1=itemView.findViewById(R.id.empty_answer_circle);
            imageView2=itemView.findViewById(R.id.clicked_answer_circle);

        }
    }
}
