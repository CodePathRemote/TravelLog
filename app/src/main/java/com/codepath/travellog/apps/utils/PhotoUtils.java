package com.codepath.travellog.apps.utils;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by lixudong on 11/13/16.
 */

public class PhotoUtils {
    private static final String APP_TAG = "TravelLog";

    public static Uri getPhotoFileUri(String photoFileName) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), APP_TAG);

        if(!mediaStorageDir.exists() && !mediaStorageDir.mkdir()) {
            Log.d(APP_TAG, "Fail to create directory");
        }

        return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator + photoFileName));
    }

    public static String generatePhotoFileName() {
        return "photo.jpg";
    }

}
