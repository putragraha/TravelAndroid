package com.neptuunia.data.account.repository;

import com.neptuunia.data.account.repository.source.AccountEntity;
import com.neptuunia.data.account.repository.source.LocalAccountEntity;

import javax.inject.Inject;

public class AccountEntityFactory {

    private LocalAccountEntity localAccountEntity;

    @Inject
    public AccountEntityFactory(LocalAccountEntity localAccountEntity) {
        this.localAccountEntity = localAccountEntity;
    }

    public AccountEntity createAccountEntity() {
        return localAccountEntity;
    }
}
