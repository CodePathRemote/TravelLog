package com.codepath.travellog.apps.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.travellog.R;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

public class LoginActivity extends AppCompatActivity {

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


}