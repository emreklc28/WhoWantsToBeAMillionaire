package com.emrekilic.whowantstobeamillionaire;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emrekilic.whowantstobeamillionaire.model.AnswerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsPage extends BaseFragment{

    List<DataMain> questions;
    int currentQuestion;

    public static QuestionsPage newInstance(List<DataMain> questions, int currentQuestion) {
        QuestionsPage fragment = new QuestionsPage();
        fragment.questions = questions;
        fragment.currentQuestion = currentQuestion;
        return fragment;

    }

    AdapterQuestions adapterQuestions = new AdapterQuestions(getActivity());

    Button answer_button;


    RecyclerView recycler_view_questions;

    TextView textView, time_text_view, textView1, textView2;
    CountDownTimer countDownTimer;
    int time = 30;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.questions_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        time_text_view = view.findViewById(R.id.time_text_view);

        recycler_view_questions = view.findViewById(R.id.recycler_view_answer);
        recycler_view_questions.setHasFixedSize(true);
        recycler_view_questions.setLayoutManager(new LinearLayoutManager(getActivity()));

        textView = view.findViewById(R.id.questions);


        loadQuestion();

       /* countDownTimer=new CountDownTimer(time*1000,1000) {
            @Override
            public void onTick(long l) {
                time--;
                time_text_view.setText(""+time);

            }

            @Override
            public void onFinish() {

                addFragment(LeaderboardPage.newInstance());

            }
        };
        countDownTimer.start();*/


        answer_button = view.findViewById(R.id.answer_button);
        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AnswerModel cheackedAnswer = adapterQuestions.getCheckedAnswer();
                Answer answer=adapterQuestions.getAnser();
                adapterQuestions.setAnswer(answer);

                if (cheackedAnswer == null) {

                    //hiç işaretlememiş
                } else if (cheackedAnswer.isCorrectAnswer()) {

                    if (currentQuestion == questions.size() - 1) {
                        addFragment(MoneyTree.newInstance(currentQuestion));

                        //bütün soruları doğru bildi , gerekli y
                    } else {
                        currentQuestion++;
                        loadQuestion();
                        MoneyTree moneyTree = MoneyTree.newInstance((currentQuestion - 1));
                        addFragment(moneyTree);
                    }

                    //answer.getAnswer_a().equals("true");
                    //addFragment(MoneyTree.newInstance(2));




                    //doğru cevap

                }

                //ysnlış cevap

            }

            // addFragment(LeaderboardPage.newInstance());

        });


    }

    private void addAnswerList(List<AnswerModel> answers, String question, String correctAnswer, String key) {
        if (!question.isEmpty()) {
            answers.add(new AnswerModel(question, false, correctAnswer.equals(key)));
        }
    }


    private void loadQuestion() {
        if (currentQuestion == 5 || currentQuestion == 10) {
            //jokeri aktif edicen
        }


        DataMain question = questions.get(currentQuestion);
        textView.setText(question.getQuestion());


        Answer answer = question.getAnswersList();

        List<AnswerModel> answers = new ArrayList<>();

        addAnswerList(answers, answer.getAnswer_a(), question.getCorrect_answer(), "answer_a");
        addAnswerList(answers, answer.getAnswer_b(), question.getCorrect_answer(), "answer_b");
        addAnswerList(answers, answer.getAnswer_c(), question.getCorrect_answer(), "answer_c");
        addAnswerList(answers, answer.getAnswer_d(), question.getCorrect_answer(), "answer_d");

        AdapterQuestions adapter = new AdapterQuestions(getActivity());
        recycler_view_questions.setAdapter(adapter);
        adapter.setAnswerModelList(answers);


    }

}
