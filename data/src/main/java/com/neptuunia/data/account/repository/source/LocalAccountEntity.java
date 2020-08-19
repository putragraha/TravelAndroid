package com.neptuunia.data.account.repository.source;

import com.neptuunia.data.account.model.Account;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LocalAccountEntity, v 0.0.1 19/08/20 11.27 by Putra Nugraha
 */
public class LocalAccountEntity implements AccountEntity {

    private static final String KEY_ID = "ID";

    private static final String KEY_TYPE = "TYPE";

    private SharedPreferences sharedPreferences;

    @Inject
    public LocalAccountEntity(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Account getSession() {
        return new Account(
            sharedPreferences.getInt(KEY_ID, 0),
            sharedPreferences.getString(KEY_TYPE, "")
        );
    }

    @Override
    public boolean saveSession(Account account) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, account.getId());
        editor.putString(KEY_TYPE, account.getType());

        return editor.commit();
    }

    @Override
    public boolean clearSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();

        return editor.commit();
    }
}
