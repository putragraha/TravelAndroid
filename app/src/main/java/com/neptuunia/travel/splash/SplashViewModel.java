package com.neptuunia.travel.splash;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.account.repository.AccountRepository;

import android.app.Application;
import android.text.TextUtils;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MainViewModel, v 0.0.1 19/08/20 12.05 by Putra Nugraha
 */
public class SplashViewModel extends AndroidViewModel {

    private MutableLiveData<String> sessionLiveData = new MutableLiveData<>();

    private AccountRepository accountRepository;

    @Inject
    public SplashViewModel(
        @NonNull Application application,
        AccountRepository accountRepository
    ) {
        super(application);
        this.accountRepository = accountRepository;
        checkSession();
    }

    public MutableLiveData<String> getSessionLiveData() {
        return sessionLiveData;
    }

    private void checkSession() {
        Account account = accountRepository.getSession();
        if (account.getId() > 0 && !TextUtils.isEmpty(account.getType())) {
            sessionLiveData.postValue(account.getType());
        }
    }
}
