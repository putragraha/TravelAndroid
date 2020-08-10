package com.neptuunia.travel;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class TravelApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}