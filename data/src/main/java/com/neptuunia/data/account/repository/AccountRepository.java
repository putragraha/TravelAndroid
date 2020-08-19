package com.neptuunia.data.account.repository;

import com.neptuunia.data.account.model.Account;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AccountRepository, v 0.0.1 19/08/20 11.23 by Putra Nugraha
 */
public interface AccountRepository {

    Account getSession();

    boolean saveSession(Account account);

    boolean clearSession();
}
