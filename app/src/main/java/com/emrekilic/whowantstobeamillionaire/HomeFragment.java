package com.emrekilic.whowantstobeamillionaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends BaseFragment{
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    private List<DataMain> allQuestions = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText=view.findViewById(R.id.user_name);
        Button leaderbord,start;

        leaderbord=view.findViewById(R.id.leaderbord);
        start=view.findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadQuestions("easy",5);



            }
        });


        leaderbord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(LeaderboardPage.newInstance());

            }
        });


    }

    private void loadQuestions(String difficulty,int limit){
        DataAPI dataAPI=Config.getRetrofit().create(DataAPI.class);
        dataAPI.getQuestion(limit,difficulty,Config.API_KEY).enqueue(new Callback<List<DataMain>>() {
            @Override
            public void onResponse(Call<List<DataMain>> call, Response<List<DataMain>> response) {
                if (response.isSuccessful()){
                    allQuestions.addAll(response.body());
                    if (difficulty.equals("easy")) {
                        loadQuestions("medium",5);
                    } else if (difficulty.equals("medium")) {
                        loadQuestions("hard",3);
                    } else if (difficulty.equals("hard")) {
                        addFragment(QuestionsPage.newInstance(allQuestions,0));
                    }

                }
            }

            @Override
            public void onFailure(Call<List<DataMain>> call, Throwable t) {

            }
        });



    }

}
