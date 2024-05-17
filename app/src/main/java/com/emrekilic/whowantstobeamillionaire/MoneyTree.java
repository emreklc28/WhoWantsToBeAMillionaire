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

public class MoneyTree extends BaseFragment{

    private int currentQuestion;

    public static MoneyTree newInstance(int currentQuestion){
        MoneyTree fragment=new MoneyTree();
        fragment.currentQuestion=currentQuestion;

        return fragment;
    }

    Button next_button;
    RecyclerView recyclerView;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.money_tree,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.money_tree_recycler_view);
        AdapterMoneyTree adapterMoneyTree=new AdapterMoneyTree();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterMoneyTree);



        next_button=view.findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addFragment(QuestionsPage.newInstance());
            }
        });






    }
}
