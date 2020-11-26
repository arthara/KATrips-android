package com.katripstask.katrips;

import android.app.Application;

import com.katripstask.katrips.utils.UtilProvider;

// Set this class to android:name in AndroidManifest.xml at application tag
public class Starter extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        UtilProvider.initialize(getApplicationContext());
    }
}
