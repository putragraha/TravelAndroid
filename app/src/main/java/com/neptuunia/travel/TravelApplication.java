package com.neptuunia.travel;

import com.neptuunia.travel.common.Flags;

import android.app.Application;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import io.rollout.android.Rox;

@HiltAndroidApp
public class TravelApplication extends Application {

    @Inject
    Flags flags;

    @Override
    public void onCreate() {
        super.onCreate();
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