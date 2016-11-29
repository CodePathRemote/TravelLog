package com.codepath.travellog.apps.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by lixudong on 11/29/16.
 */

@IgnoreExtraProperties
public class User {
    public List<String> pics;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(List<String> pics) {
        this.pics = pics;
    }

}
