package com.codepath.travellog.apps.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.travellog.R;
import com.facebook.FacebookSdk;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);

    }


}