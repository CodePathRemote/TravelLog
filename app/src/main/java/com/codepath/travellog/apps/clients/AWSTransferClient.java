package com.codepath.travellog.apps.clients;

import android.content.Context;

import com.amazonaws.auth.CognitoCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;

public class AWSTransferClient {
    public static final String BUCKET_NAME = "test-bucket-for-android";

    protected Context context;
    protected TransferUtility transferClient;

    public AWSTransferClient(Context context, CognitoCredentialsProvider credentialsProvider) {
        this.context = context;
        this.transferClient = new TransferUtility(new AmazonS3Client(credentialsProvider), context);
    }

    public void uploadFile(String fileName, File fileToUpload) {
        TransferObserver observer = transferClient.upload(
                BUCKET_NAME,   /* The bucket to upload to */
                fileName,      /* The key for the uploaded object */
                fileToUpload   /* The file where the data to upload exists */
        );
    }
}
