package com.neptuunia.travel.utils;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version Transformer, v 0.0.1 03/08/20 08.44 by Putra Nugraha
 */
public class Transformer {

    private Transformer() {
        // Prevent instantiation
    }

    public static <T> Single<T> applySchedulers(@NonNull Single<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
