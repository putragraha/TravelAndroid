package com.neptuunia.data.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

@StringDef({Source.MOCK, Source.NETWORK})
@Retention(RetentionPolicy.SOURCE)
public @interface Source {

    String MOCK = "mock";

    String NETWORK = "network";
}
