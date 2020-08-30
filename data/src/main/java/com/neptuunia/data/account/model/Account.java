package com.neptuunia.data.account.model;

import com.neptuunia.data.constant.AccountType;

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
