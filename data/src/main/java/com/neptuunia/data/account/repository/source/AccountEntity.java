package com.neptuunia.data.account.repository.source;

import com.neptuunia.data.account.model.Account;

public interface AccountEntity {

    Account getSession();

    boolean saveSession(Account account);

    boolean clearSession();
}
