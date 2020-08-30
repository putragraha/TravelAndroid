package com.neptuunia.data.constant;

import com.neptuunia.data.account.model.Account;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

@StringDef({AccountType.DRIVER, AccountType.USER})
@Retention(RetentionPolicy.SOURCE)
public @interface AccountType {

    String DRIVER = "driver";

    String USER = "user";
}
