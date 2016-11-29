package com.codepath.travellog.apps.clients;

import android.net.Uri;
import android.support.annotation.NonNull;

import com.codepath.travellog.apps.model.User;
import com.codepath.travellog.apps.utils.PhotoUtils;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vmiha on 11/27/16.
 */

public class FirebaseClient {

    static FirebaseStorage storage = FirebaseStorage.getInstance();

    static DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public static boolean downloaddMarker() {

        return true;

    }

    public static void uploadMarker(final String photoName, final Marker marker, final String userId) {
        Uri takenPhotoUri = PhotoUtils.getPhotoFileUri(photoName);
        marker.setTag(takenPhotoUri);
        // Create a storage reference from our app
        StorageReference storageRef = storage.getReferenceFromUrl("gs://my-project-1478752187590.appspot.com");
        final StorageReference imagesRef = storageRef.child("marker/" + photoName);
        updatePhotoReference(userId, photoName);

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

    private static void updatePhotoReference(final String userId, final String photoName) {
        database.child("users").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                List<String> markernames = user.pics;
                markernames.add(photoName);
                writeNewUser(markernames, userId);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private static void writeNewUser(List<String> photoNames, String userId) {
        User newUser = new User(photoNames);
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userId, newUser);

        database.updateChildren(childUpdates);
    }

}
