package com.neptuunia.data.account.repository;

import com.neptuunia.data.account.model.Account;

import javax.inject.Inject;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AccountEntityRepository, v 0.0.1 19/08/20 11.25 by Putra Nugraha
 */
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
