package com.neptuunia.travel;

import com.neptuunia.travel.common.Flags;

import javax.inject.Inject;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import dagger.hilt.android.HiltAndroidApp;
import io.rollout.android.Rox;

@HiltAndroidApp
public class TravelApplication extends MultiDexApplication {

    @Inject
    Flags flags;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        initRox();
    }

    public Flags getFlags() {
        return flags;
    }

    private void initRox() {
        Rox.register("", flags);
        Rox.setup(this);
    }
}