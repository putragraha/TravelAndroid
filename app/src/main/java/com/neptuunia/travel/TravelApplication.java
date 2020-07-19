package com.neptuunia.travel;

import com.neptuunia.travel.common.Flags;

import android.app.Application;

import io.rollout.android.Rox;

public class TravelApplication extends Application {

    private Flags flags;

    @Override
    public void onCreate() {
        super.onCreate();
        initRox();
    }

    public Flags getFlags() {
        return flags;
    }

    private void initRox() {
        flags = new Flags();
        Rox.register("", flags);
        Rox.setup(this);
    }
}