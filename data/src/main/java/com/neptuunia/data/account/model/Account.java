package com.neptuunia.data.account.model;

import com.neptuunia.data.constant.AccountType;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AccountResponse, v 0.0.1 19/08/20 11.19 by Putra Nugraha
 */
public class Account {

    private int id;

    @AccountType
    private String type;

    public Account(int id, @AccountType String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
