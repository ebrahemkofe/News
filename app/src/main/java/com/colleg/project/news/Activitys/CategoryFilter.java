package com.colleg.project.news.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import com.colleg.project.news.Adapters.AdapterOfSearch;
import com.colleg.project.news.Models.ModelOfSearchResult;
import com.colleg.project.news.MyUtils.MyUtils;
import com.colleg.project.news.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilter extends AppCompatActivity {


    List<ModelOfSearchResult.PostsBean>list = new ArrayList();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_filter);
        listView = findViewById(R.id.list_item_filter);


        Get_Data(Home.categoryId);
        onClick();
    }


    private void onClick(){

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyUtils.PostID  = String.valueOf(list.get(position).getPost_id());
                Intent i = new Intent(CategoryFilter.this,Details.class);
                startActivity(i);
                finish();

            }
        });

    }


    private void Get_Data (int id){

        JSONObject object = new JSONObject();
        try {
         object.put("id",id);

        } catch (JSONException e) {
            e.getStackTrace();
        }



        AndroidNetworking.post("https://cizaro.net/2030/api/categoryposts")
                .addJSONObjectBody(object)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        ModelOfSearchResult array = gson.fromJson(response.toString(), ModelOfSearchResult.class);

                        list = array.getPosts() ;

                        listView.setAdapter(new AdapterOfSearch(CategoryFilter.this,R.layout.item_listview_favourite,list));









                    }

                    @Override
                    public void onError(ANError anError) {





                    }
                });





    }
}
