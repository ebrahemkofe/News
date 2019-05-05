package com.colleg.project.news.Activitys;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.colleg.project.news.InternalStorage.mySharedPreference;
import com.colleg.project.news.Models.ModelOfRejestraion;
import com.colleg.project.news.R;
import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends AppCompatActivity {
    private Button loginWithGoogle ;
    private int RC_SIGN_IN = 123;
    private CallbackManager callbackManager;
    private GoogleSignInClient mGoogleSignInClient;
    private String sEmail , sPassword ;

    private EditText editEmail , editpassword ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         mySharedPreference.init(this);

        editEmail = findViewById(R.id.editTextEmailForLogin);
        editpassword = findViewById(R.id.editTextPassword) ;



        definitions();

        googleToken();

        onClick();





    }

    private void onClick(){
        loginWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });
    }


    private void definitions(){
        loginWithGoogle = findViewById(R.id.login_with_google);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            //Google response

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

//            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            int statusCode = result.getStatus().getStatusCode();

        } else {
            //facebook response
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }


    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            Toast.makeText(this,   account.getDisplayName()+",m,m,m", Toast.LENGTH_SHORT).show();


        } catch (ApiException e) {



            Toast.makeText(this, "Failed to do Sign In", Toast.LENGTH_SHORT).show();
        }
    }
    private void googleToken() {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    private void printKeyHash() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.colleg.project.news", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());

                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("KeyHash:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("KeyHash:", e.toString());
        }
    }

    private void onLoginData( String password,  String email) {
        JSONObject object = new JSONObject();
        try {

            object.put("email", email);
            object.put("password", password);


        } catch (JSONException e) {
            e.getStackTrace();
        }



        AndroidNetworking.post("https://cizaro.net/2030/api/login")
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
                        Toast.makeText(Login.this, mySharedPreference.getUserOBJ()+"", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(ANError anError) {

                        Toast.makeText(Login.this, anError.getErrorBody()+"", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void  validationRegisterData ( String email1  , String password1  ){

        if (email1.equals("")){
            editEmail.setError("Required");



        }else if(password1.equals("")){
            editpassword.setError("Required");

        }else {
            onLoginData(email1 ,password1  );

        }


    }



    public void login(View view) {

        sEmail = editEmail.getText().toString();
        sPassword = editpassword.getText().toString();

        validationRegisterData( sEmail , sPassword );
    }
}
