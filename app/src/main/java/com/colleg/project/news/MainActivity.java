package com.colleg.project.news;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> listDate = new ArrayList<>();
        listDate.add(R.drawable.logo);
        listDate.add(R.drawable.ic_launcher_background);
        listDate.add(R.drawable.logo);

        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this, listDate));
    }


}
