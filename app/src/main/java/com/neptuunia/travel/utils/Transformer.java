package com.neptuunia.travel.utils;

import androidx.annotation.NonNull;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Transformer {

    private Transformer() {
        // Prevent instantiation
    }

    public static <T> Single<T> applySchedulers(@NonNull Single<T> upstream) {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
