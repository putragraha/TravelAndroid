package com.neptuunia.data.constant;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author nSystem
 * @version Source, v 0.0.1 19/07/20 15.27 by nSystem
 */
@StringDef({Source.MOCK, Source.NETWORK})
@Retention(RetentionPolicy.SOURCE)
public @interface Source {

    String MOCK = "mock";

    String NETWORK = "network";
}
