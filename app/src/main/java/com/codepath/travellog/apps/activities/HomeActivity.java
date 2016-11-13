package com.codepath.travellog.apps.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.codepath.travellog.R;
import com.codepath.travellog.apps.fragments.MapsFragment;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MapsFragment mapsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // replace action bar with toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**
         * create a hook to the fragment so that you can invoke methods on it from the activity
         * mapsFragment.setMarker("Set a marker");
         * make sure to call methods on mapsFragment only after it has loaded - onConnected() has been called so outside of this method
         */
        if(savedInstanceState == null) {
            mapsFragment = (MapsFragment) getSupportFragmentManager().findFragmentById(R.id.child_fragment_container);
        }

    }
}
