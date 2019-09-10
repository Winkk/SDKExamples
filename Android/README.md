This Android project demonstrates how to integrate and use Winkk SDK.

To launch this demo, [download](https://dev.winkk.com/partner/sdk/winkk_1.0.0_dev.aar) Winkk SDK library AAR-archive and copy it into `app/libs/` folder of the project.

To configure any other Android project to be integrated with Winkk SDK:

1. Make sure you have configured an application integration with **WAuth Mobile** interface and provided your application's package or Bundle ID in the [Partner Tool](https://passport.winkk.com/partner)'s **Applications** section.

2. [Download](https://dev.winkk.com/partner/sdk/winkk_1.0.0_dev.aar) Winkk SDK library AAR-archive and copy it into `libs/` folder of your project's target module.

3. Declare the downloaded library and its' dependencies in `dependencies` section in `build.gradle` file of your project's target module:
```
implementation fileTree(dir: 'libs', include: ['*.jar', '*.aar'])
implementation 'com.google.code.gson:gson:2.8.2'
implementation 'com.android.volley:volley:1.1.0'
implementation 'android.arch.lifecycle:extensions:1.1.1'
```

4. Declare all required library's permissions in your `AndroidManifest.xml` file:
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

5. Initialize the SDK with your application's ID obtained in the first step:
```
Winkk.SDK.initialize(getApplicationContext(), "YOUR_APPLICATION_ID");
```
The best place for this initialization is in your `Application`'s `onCreate` method.

6. Start the authorization session with `Winkk.SDK.start(context, callback);` call.

7. If you want to use an obfuscation, make sure to prevent Winkk SDK from it (it is already obfuscated) by adding the following lines to your `proguard-rules.pro`:
```
-keep class com.winkk.sdk.** { public protected private *; }
```

