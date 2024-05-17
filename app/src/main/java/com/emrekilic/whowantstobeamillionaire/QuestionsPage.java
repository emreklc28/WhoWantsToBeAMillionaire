package com.emrekilic.whowantstobeamillionaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrekilic.whowantstobeamillionaire.model.AnswerModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsPage extends BaseFragment{

    List<DataMain> questions;
    int currentQuestion;

    public static QuestionsPage newInstance(List<DataMain> questions, int currentQuestion){
        QuestionsPage fragment=new QuestionsPage();
        fragment.questions=questions;
        fragment.currentQuestion=currentQuestion;
        return fragment;

    }

    Button answer_button;

    RecyclerView recycler_view_questions;

    TextView textView;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.questions_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // recycler_view_questions=view.findViewById(R.id.recycler_view_questions);
        //recycler_view_questions.setHasFixedSize(true);
      //  recycler_view_questions.setLayoutManager(new LinearLayoutManager(getActivity()));
       // AdapterQuestions adapter=new AdapterQuestions(getActivity());
       // recycler_view_questions.setAdapter(adapter);
        textView=view.findViewById(R.id.question);
        loadQuestion();










        answer_button=view.findViewById(R.id.answer_button);
        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdapterQuestions adapterQuestions = new AdapterQuestions(getActivity());

                AnswerModel cheackedAnswer = adapterQuestions.getCheckedAnswer();

                if (cheackedAnswer == null) {
                    //hiç işaretlememiş
                } else if (cheackedAnswer.isCorrectAnswer()) {
                    if (currentQuestion == questions.size() - 1) {
                        //bütün soruları doğru bildi , gerekli y
                    } else {
                        currentQuestion++;
                        loadQuestion();
                        MoneyTree moneyTree = MoneyTree.newInstance((currentQuestion - 1));
                        addFragment(moneyTree);
                    }
                    //doğru cevap
                } else {
                    //ysnlış cevap
                }


               // addFragment(MoneyTree.newInstance());




            }
        });


    }



    private void loadQuestion(){
        if (currentQuestion == 5 ||currentQuestion == 10) {
            //jokeri aktif edicen
        }


        DataMain question=questions.get(currentQuestion);
        textView.setText(question.getQuestion());

        Answer answer = question.getAnswersList();

        List<AnswerModel> answers = new ArrayList<>();

        answers.add(new AnswerModel(answer.getAnswer_a(),false,question.getCorrect_answer().equals("answer_a")));
        answers.add(new AnswerModel(answer.getAnswer_b(),false,question.getCorrect_answer().equals("answer_b")));
        answers.add(new AnswerModel(answer.getAnswer_c(),false,question.getCorrect_answer().equals("answer_c")));
        answers.add(new AnswerModel(answer.getAnswer_d(),false,question.getCorrect_answer().equals("answer_d")));

        //set Adapter



       // textView.setText(question.getAnswersList().getAnswer_a());







    }




}
