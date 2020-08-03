package com.neptuunia.travel.utils;

import android.util.Log;

import io.reactivex.rxjava3.observers.DisposableSingleObserver;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AutoDisposeSingleObserver, v 0.0.1 03/08/20 09.03 by Putra Nugraha
 */
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
