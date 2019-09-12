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
                "5d7a67c8491f1e00016bb9ad"); // application (interface) ID registered in the Partner Panel
    }

}
