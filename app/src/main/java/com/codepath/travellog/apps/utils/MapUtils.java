package com.codepath.travellog.apps.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.view.animation.BounceInterpolator;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

/**
 * Created by vmiha on 11/12/16.
 */

public class MapUtils {

    public static BitmapDescriptor createBubble(Context context, int style, String title) {
        IconGenerator iconGenerator = new IconGenerator(context);
        iconGenerator.setStyle(style);
        Bitmap bitmap = iconGenerator.makeIcon(title);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
        return bitmapDescriptor;
    }

    public static BitmapDescriptor createPictureBubble(Context context, String filePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 100, 150, true);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(scaledBitmap);
        return bitmapDescriptor;
    }

    public static Marker addMarker(GoogleMap map, LatLng point, String title,
                                   BitmapDescriptor icon) {



        // Creates and adds marker to the map
        MarkerOptions options = new MarkerOptions()
                .position(point)
                .title(title)
                .icon(icon);
        return map.addMarker(options);
    }

    public static void dropPinEffect(final Marker marker) {
        // Handler allows us to repeat a code block after a specified delay
        final android.os.Handler handler = new android.os.Handler();
        final long start = SystemClock.uptimeMillis();
        final long duration = 1500;

        // Use the bounce interpolator
        final android.view.animation.Interpolator interpolator =
                new BounceInterpolator();

        // Animate marker with a bounce updating its position every 15ms
        handler.post(new Runnable() {
            @Override
            public void run() {
                long elapsed = SystemClock.uptimeMillis() - start;
                // Calculate t for bounce based on elapsed time
                float t = Math.max(
                        1 - interpolator.getInterpolation((float) elapsed
                                / duration), 0);
                // Set the anchor
                marker.setAnchor(0.5f, 1.0f + 14 * t);

                if (t > 0.0) {
                    // Post this event again 15ms from now.
                    handler.postDelayed(this, 15);
                } else { // done elapsing, show window
//                    marker.showInfoWindow();
                }
            }
        });
    }
}