package com.winkk.sdk.demo;

import android.app.Application;

import com.winkk.sdk.Winkk;

/**
 * This class is marked in the manifest as application's class.
 * */
public class DemoApplication extends Application {

    /**
     * This method - is the best place to initialize the SDK.
     * */
    @Override
    public void onCreate() {
        super.onCreate();

        // This initialization is required before any usage of the SDK.
        Winkk.SDK.initialize(
                getApplicationContext(),
                "5d5aafc1670d9d00012ea5e0"); // application (interface) ID registered in the Partner Panel
    }

}
