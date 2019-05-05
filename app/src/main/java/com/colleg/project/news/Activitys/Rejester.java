package com.colleg.project.news.Activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.colleg.project.news.InternalStorage.mySharedPreference;
import com.colleg.project.news.Models.ModelOfRejestraion;
import com.colleg.project.news.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class Rejester extends AppCompatActivity {


    EditText userName , email  , password , repassword  ;

    String sUserName   ,sEmail , sPassword , sRepassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejester);

         mySharedPreference.init(this);
        userName = findViewById(R.id.userName);
        email  =findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);


        Gson gson = new Gson();
        ModelOfRejestraion.UserInfoBean m = gson.fromJson(mySharedPreference.getUserOBJ() , ModelOfRejestraion.UserInfoBean.class);


        Toast.makeText(this, m.getUserId()+"", Toast.LENGTH_SHORT).show();









    }


    private void  validationRegisterData (String userName1  , String email1  , String password1  , String repassword1 ){

        if (userName1.equals("")){
            userName.setError("Required");

        }else if (email1.equals("")){
            email.setError("Required");

        }else if(password1.equals("")){
            password.setError("Required");

        }else if(!repassword1.equals(password1)){
            repassword.setError("Not Matched");
        }else {
            onRegisterData(userName1 ,password1  , email1 );

        }


    }


    private void onRegisterData(String name, String password,  String email) {
        JSONObject object = new JSONObject();
        try {
            object.put("user_name", name);
            object.put("email", email);
            object.put("password", password);


        } catch (JSONException e) {
            e.getStackTrace();
        }



        AndroidNetworking.post("https://cizaro.net/2030/api/registration")
                .addJSONObjectBody(object)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {



                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        ModelOfRejestraion resPOJO = gson.fromJson(response.toString(), ModelOfRejestraion.class);


                        String userOBJSTR = gson.toJson(resPOJO.getUser_info());



                        mySharedPreference.setUserOBJ(userOBJSTR);
                        Toast.makeText(Rejester.this, mySharedPreference.getUserOBJ()+"", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(Rejester.this, anError.getErrorBody()+"", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void rejest(View view) {
        sUserName = userName.getText().toString();
        sEmail = email.getText().toString();
        sPassword = password.getText().toString();
        sRepassword = repassword.getText().toString();
        validationRegisterData(sUserName , sEmail , sPassword , sRepassword);
    }
}
