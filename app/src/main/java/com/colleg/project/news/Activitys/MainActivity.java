package com.colleg.project.news.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.colleg.project.news.Fragments.HomeFragment;
import com.colleg.project.news.R;

public class MainActivity extends AppCompatActivity {


    Fragment fragment;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment = new HomeFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout, fragment, "Home_Fragment");
        transaction.commitNow();
    }


    public void favourite(View view) {


    }

    public void home(View view) {
        fragment = new HomeFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout, fragment, "Home_Fragment");
        transaction.commitNow();
    }

    public void profile(View view){

    }


}
