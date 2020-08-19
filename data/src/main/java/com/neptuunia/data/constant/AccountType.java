package com.neptuunia.data.constant;

import com.neptuunia.data.account.model.Account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AccountType, v 0.0.1 19/08/20 11.20 by Putra Nugraha
 */
@StringDef({AccountType.DRIVER, AccountType.USER})
@Retention(RetentionPolicy.SOURCE)
public @interface AccountType {

    String DRIVER = "driver";

    String USER = "user";
}
