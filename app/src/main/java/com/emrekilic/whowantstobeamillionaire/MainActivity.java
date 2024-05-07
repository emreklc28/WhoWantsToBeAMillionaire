package com.emrekilic.whowantstobeamillionaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;

public class MainActivity extends AppCompatActivity implements FragNavController.RootFragmentListener {

    private FragNavController fragNavController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragNavController = new FragNavController(getSupportFragmentManager(),R.id.frameLayout);
        fragNavController.setRootFragmentListener(this);
        fragNavController.initialize(0,savedInstanceState);



    }

    public void addFragment(Fragment fragment) {
        fragNavController.pushFragment(fragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!fragNavController.popFragment()) {
            finish();
        }
    }

    public void clearAllFragment() {
        fragNavController.clearStack(0);
    }

    public void closeFragmentAndOpenFragment(Fragment fragment) {
        onBackPressed();
        addFragment(fragment);
    }

    public void clearFragmentsAndOpenFragment(Fragment fragment) {
        fragNavController.clearStack(0);
        fragNavController.pushFragment(fragment);
    }

    @Override
    public int getNumberOfRootFragments() {
        return 1;
    }

    @NonNull
    @Override
    public Fragment getRootFragment(int i) {
        return HomeFragment.newInstance();
    }
}