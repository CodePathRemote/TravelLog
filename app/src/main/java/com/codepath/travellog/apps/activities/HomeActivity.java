package com.codepath.travellog.apps.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.codepath.travellog.R;
import com.codepath.travellog.apps.fragments.LoginFragment;
import com.codepath.travellog.apps.fragments.MapsFragment;
import com.codepath.travellog.apps.utils.PhotoUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {

    private final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;

    private Toolbar toolbar;
    private Toolbar toolbarBottom;
    private MapsFragment mapsFragment;

    private DrawerLayout mDrawer;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // replace action bar with toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // set up the drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        FacebookSdk.sdkInitialize(getApplicationContext());
        // AppEventsLogger.activateApp(this);

        storage = FirebaseStorage.getInstance();

        nvDrawer.getMenu().getItem(0).setChecked(true);
        FragmentManager fragmentManager = getSupportFragmentManager();
      //  if(AccessToken.getCurrentAccessToken() != null) {
            fragmentManager.beginTransaction().replace(R.id.flContent, new MapsFragment(), "MapFragment").commit();
       // } else {
       //     fragmentManager.beginTransaction().replace(R.id.flContent, new LoginFragment(), "LoginFragment").commit();
        //}
        setTitle(R.string.app_name);

        toolbarBottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        toolbarBottom.inflateMenu(R.menu.bottom_toolbar_menu);
        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(!isUserSignedIn()) {return false;}
                if(item.getItemId() == R.id.photo) {
                    String photoFileName = PhotoUtils.generatePhotoFileName();
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, PhotoUtils.getPhotoFileUri(photoFileName));
                    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                }
                if (item.getItemId() == R.id.notes) {
                    openNotes();
                }
                return false;
            }
        });

        /**
         * created a hook to the fragment so that you can invoke methods on it from the activity
         * mapsFragment.setMarker("Set a marker");
         * make sure to call methods on mapsFragment only after it has loaded - onConnected() has been called so outside of this method
         */
        if(savedInstanceState == null) {
            mapsFragment = (MapsFragment) getSupportFragmentManager().findFragmentById(R.id.child_fragment_container);
        }
    }

    private void openNotes() {
        Intent i = new Intent(this, NotesActivity.class);
        //startActivityForResult(i, SETTINGS_RESULT);
        HomeActivity.this.startActivity(i);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if(!isUserSignedIn()) {return false;}
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });

    }
    public void selectDrawerItem(MenuItem menuItem) {

        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.map:
                fragmentClass = MapsFragment.class;
                break;
            case R.id.trips:
                fragmentClass = MapsFragment.class;
                break;

            case R.id.profile:
                fragmentClass = LoginFragment.class;
                break;
            default:
                fragmentClass = MapsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);

        // Set action bar title
        setTitle(menuItem.getTitle());

        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isUserSignedIn() {
        return (AccessToken.getCurrentAccessToken() != null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String photoName = PhotoUtils.generatePhotoFileName();
                Uri takenPhotoUri = PhotoUtils.getPhotoFileUri(photoName);
                // Bitmap takenImage = BitmapFactory.decodeFile(takenPhotoUri.getPath());
                if (mapsFragment == null) {
                    mapsFragment = (MapsFragment) getSupportFragmentManager().findFragmentByTag("MapFragment");
                }
                // Create a storage reference from our app
                StorageReference storageRef = storage.getReferenceFromUrl("gs://my-project-1478752187590.appspot.com");
                StorageReference mountainImagesRef = storageRef.child("images/" + photoName);
                try {
                    InputStream stream = new FileInputStream(new File(takenPhotoUri.getPath()));
                    UploadTask uploadTask = mountainImagesRef.putStream(stream);
                    uploadTask.addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            String haha = "test";
                            final int length = haha.length();
                            // Handle unsuccessful uploads
                        }
                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                            Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        }
                    });


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                mapsFragment.setPictureMarker("title", takenPhotoUri.getPath());

                Toast.makeText(this, takenPhotoUri.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
