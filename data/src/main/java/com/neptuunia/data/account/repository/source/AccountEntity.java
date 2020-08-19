package com.neptuunia.data.account.repository.source;

import com.neptuunia.data.account.model.Account;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AccountEntity, v 0.0.1 19/08/20 11.26 by Putra Nugraha
 */
public interface AccountEntity {

    Account getSession();

    boolean saveSession(Account account);

    boolean clearSession();
}
