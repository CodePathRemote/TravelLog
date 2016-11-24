package com.codepath.travellog.apps.aplications;

import android.app.Application;
import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.codepath.travellog.apps.clients.AWSTransferClient;
import com.facebook.FacebookSdk;

public class TravelLogApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        TravelLogApplication.context = this;
    }

    public static CognitoCredentialsProvider getCredentialProvider() {
        // Initialize the Amazon Cognito credentials provider
        return new CognitoCachingCredentialsProvider(
                TravelLogApplication.context,
                "us-east-1:362a2090-e289-47f4-8bb3-92a1b973ab33", // Identity Pool ID
                Regions.US_EAST_1 // Region
        );
    }

    public static AWSTransferClient getTransferClient() {
        return new AWSTransferClient(TravelLogApplication.context, getCredentialProvider());
    }
}
