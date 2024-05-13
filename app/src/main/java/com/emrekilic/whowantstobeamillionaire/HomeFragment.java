package com.emrekilic.whowantstobeamillionaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeFragment extends BaseFragment{
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }


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
                addFragment(QuestionsPage.newInstance());
            }
        });


        leaderbord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(LeaderboardPage.newInstance());

            }
        });


    }

}
