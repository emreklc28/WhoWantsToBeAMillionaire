package com.emrekilic.whowantstobeamillionaire;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class QuestionsPage extends BaseFragment{

    public static QuestionsPage newInstance(){
        return new  QuestionsPage();

    }

    Button answer_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.questions_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        answer_button=view.findViewById(R.id.answer_button);
        answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(MoneyTree.newInstance());
            }
        });





    }
}
