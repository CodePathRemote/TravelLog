package com.codepath.travellog.apps.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.codepath.travellog.R;

public class NotesActivity extends AppCompatActivity {

    ImageView ivClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ivClose = (ImageView) findViewById(R.id.ivClose);
        


    }
}
