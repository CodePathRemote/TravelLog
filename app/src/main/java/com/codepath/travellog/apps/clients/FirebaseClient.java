package com.codepath.travellog.apps.clients;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.codepath.travellog.apps.utils.PhotoUtils;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by vmiha on 11/27/16.
 */

public class FirebaseClient {

    static FirebaseStorage storage = FirebaseStorage.getInstance();

    public static boolean downloaddMarker() {

        return true;

    }

    public static void uploadMarker(final String photoName, final Marker marker) {
        Uri takenPhotoUri = PhotoUtils.getPhotoFileUri(photoName);
        marker.setTag(takenPhotoUri);
        // Create a storage reference from our app
        StorageReference storageRef = storage.getReferenceFromUrl("gs://my-project-1478752187590.appspot.com");
        final StorageReference imagesRef = storageRef.child("marker/" + photoName);

        try {
            InputStream stream = new FileInputStream(new File(takenPhotoUri.getPath()));
            UploadTask uploadTask = imagesRef.putStream(stream);
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
                    marker.setTag(downloadUrl);
                }
            });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
