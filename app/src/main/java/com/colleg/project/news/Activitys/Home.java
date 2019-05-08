package com.colleg.project.news.Activitys;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.colleg.project.news.Adapters.CustomPagerAdapterAcc;
import com.colleg.project.news.Adapters.CustomPagerAdapterSports;
import com.colleg.project.news.Adapters.CustomPagerAdapterTran;
import com.colleg.project.news.Fragments.Favourite;
import com.colleg.project.news.Fragments.HomeFragment;
import com.colleg.project.news.Models.GsonForHome;
import com.colleg.project.news.MyUtils.MyUtils;
import com.colleg.project.news.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private   Fragment fragment;
    private   FragmentTransaction transaction;
    private   ListView listView  ;
    private   long backPressedTime  ;
    private   List<GsonForHome.NewsBean> listGson =new ArrayList<>();
    private   String [] arrayOfnav ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_in_our_app);

        listView  =findViewById(R.id.items_listView_for_navigation);

         MyUtils.setLocale(this);
         navFunction();
         Get_Data();
         firstFragmentRun();






    }
    private void firstFragmentRun(){
        fragment = new HomeFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout, fragment, "Home_Fragment");
        transaction.commitNow();

    }



    private void Get_Data() {

        AndroidNetworking.get("https://cizaro.net/2030/api/allnews")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {


                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        GsonForHome array = gson.fromJson(response.toString(), GsonForHome.class);

                        listGson = array.getNews();

                        dataForNav();


                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(Home.this, "connection field", Toast.LENGTH_SHORT).show();

                    }
                });
    }



    private void dataForNav(){
        arrayOfnav = new String[listGson.size()];

        for(int x = 0 ; x <listGson.size() ; x++){



            arrayOfnav [x]  = listGson.get(x).getCategory_title() ;
        }

        ArrayAdapter <String> arrayAdapter  = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,arrayOfnav);

        listView.setAdapter(arrayAdapter);


    }






    public void favourite(View view) {
        fragment = new Favourite();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout, fragment, "Home_Fragment");
        transaction.commitNow();
    }

    public void profile(View view) {
    }

    public void home(View view) {
        fragment = new HomeFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentLayout, fragment, "Home_Fragment");
        transaction.commitNow();

    }

    private void navFunction(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.nav);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { drawer.openDrawer(Gravity.RIGHT); } });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                finishAffinity();
            } else {
                Toast.makeText(this, "press again to exit ", Toast.LENGTH_SHORT).show();
            }

            backPressedTime = System.currentTimeMillis();
        }


    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();



        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
