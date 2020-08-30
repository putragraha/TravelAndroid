package com.neptuunia.data.account.repository;

import com.neptuunia.data.account.model.Account;

import javax.inject.Inject;

public class AccountEntityRepository implements AccountRepository {

    private AccountEntityFactory accountEntityFactory;

    @Inject
    public AccountEntityRepository(AccountEntityFactory accountEntityFactory) {
        this.accountEntityFactory = accountEntityFactory;
    }

    @Override
    public Account getSession() {
        return accountEntityFactory.createAccountEntity().getSession();
    }

    @Override
    public boolean saveSession(Account account) {
        return accountEntityFactory.createAccountEntity().saveSession(account);
    }

    @Override
    public boolean clearSession() {
        return accountEntityFactory.createAccountEntity().clearSession();
    }
}
