package com.neptuunia.travel.utils;

import android.util.Log;

import io.reactivex.rxjava3.observers.DisposableSingleObserver;

public class AutoDisposeSingleObserver<T> extends DisposableSingleObserver<T> {

    private static final String TAG = "AutoDisposeSingleObserv";

    @Override
    public void onSuccess(T t) {
        dispose();
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: " + e.getMessage());
        dispose();
    }
}
