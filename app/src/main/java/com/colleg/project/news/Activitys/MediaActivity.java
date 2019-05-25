package com.colleg.project.news.Activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.colleg.project.news.Adapters.CustomPagerAdapterAcc;
import com.colleg.project.news.Adapters.CustomPagerAdapterSports;
import com.colleg.project.news.Adapters.CustomPagerAdapterTran;
import com.colleg.project.news.Adapters.CustomPagerAdapterfifth;
import com.colleg.project.news.Adapters.CustomPagerAdapterfourth;
import com.colleg.project.news.Adapters.CustomPagerAdapterseventh;
import com.colleg.project.news.Adapters.CustomPagerAdaptersixith;
import com.colleg.project.news.Fragments.Favourite;
import com.colleg.project.news.Fragments.GallaryFragment;
import com.colleg.project.news.Fragments.VideosFragment;
import com.colleg.project.news.Models.GsonForHome;
import com.colleg.project.news.Models.ModelMediaPhotos;
import com.colleg.project.news.MyUtils.MyUtils;
import com.colleg.project.news.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MediaActivity extends AppCompatActivity {

    Fragment fragment;
    FragmentTransaction transaction;
    Button photos,videos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        fragment = new VideosFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.MediaFragment, fragment, "Home_Fragment");
        transaction.commitNow();

        photos=findViewById(R.id.Photos);
        videos=findViewById(R.id.Videos);

        photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                photos.setBackgroundResource(R.color.BlueClicked);
                videos.setBackgroundResource(R.color.Blue);

                fragment = new GallaryFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.MediaFragment, fragment, "Home_Fragment");
                transaction.commitNow();
            }
        });

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videos.setBackgroundResource(R.color.BlueClicked);
                photos.setBackgroundResource(R.color.Blue);

                fragment = new VideosFragment();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.MediaFragment, fragment, "Home_Fragment");
                transaction.commitNow();
            }
        });

    }

}
