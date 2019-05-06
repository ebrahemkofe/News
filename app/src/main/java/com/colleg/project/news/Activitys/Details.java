package com.colleg.project.news.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.colleg.project.news.Adapters.CustomPagerAdapterAcc;
import com.colleg.project.news.Models.GsonForDetails;
import com.colleg.project.news.Models.GsonForHome;
import com.colleg.project.news.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    ImageView image;
    TextView Title , Ldis , SDis;
    ImageView more_acc;
    LinearLayout morelayout_acc;
    boolean c=false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image=findViewById(R.id.image_details);
        Title=findViewById(R.id.title_details);
        Ldis=findViewById(R.id.dis_details);
        SDis=findViewById(R.id.more_details);

        more_acc=findViewById(R.id.more_det);
        morelayout_acc=findViewById(R.id.more_in_det);
        more_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c==false) {
                    morelayout_acc.setVisibility(View.VISIBLE);
                    c=true;
                }
                else{
                    morelayout_acc.setVisibility(View.GONE);
                    c=false;
                }
            }
        });
        initiateData();
    }



    private void initiateData() {
        JSONObject object = new JSONObject();
        try {
            object.put("id", CustomPagerAdapterAcc.PostID);
            Log.d("IdProject", CustomPagerAdapterAcc.PostID + " T");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AndroidNetworking.post("https://cizaro.net/2030/api/singel_post")
                .addJSONObjectBody(object)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        Log.d("TestData", "onResponse: " + response.toString());
                        GsonForDetails array = gson.fromJson(response.toString(), GsonForDetails.class);

                        Glide.with(Details.this).load(array.getPost_img()).into(image);
                        Title.setText(array.getPost_title());
                        Ldis.setText(array.getLong_description());
                        SDis.setText(array.getShort_description());




                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("TestData", "onResponse: " + anError.toString());


                    }
                });

    }



}
