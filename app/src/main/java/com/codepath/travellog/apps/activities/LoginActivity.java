package com.codepath.travellog.apps.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.travellog.R;
import com.codepath.travellog.apps.fragments.LoginFragment;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements LoginFragment.onLoginUpdatedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        if(AccessToken.getCurrentAccessToken() != null) {
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }

        setContentView(R.layout.activity_login);

    }

    @Override
    public void saveLoginInfo(FirebaseUser user) {
        SharedPreferences userInfo = getSharedPreferences("Login", 0);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString("UserId", user.getUid());
        editor.putString("UserName", user.getDisplayName());
        editor.commit();
    }

}