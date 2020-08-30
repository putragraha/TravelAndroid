package com.neptuunia.data.account.repository;

import com.neptuunia.data.account.model.Account;

public interface AccountRepository {

    Account getSession();

    boolean saveSession(Account account);

    boolean clearSession();
}
