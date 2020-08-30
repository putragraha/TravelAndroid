package com.neptuunia.travel.homedriver;

import com.neptuunia.data.account.repository.AccountRepository;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class HomeDriverViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> sessionLiveData = new MutableLiveData<>();

    private AccountRepository accountRepository;

    @Inject
    public HomeDriverViewModel(
        @NonNull Application application,
        AccountRepository accountRepository
    ) {
        super(application);
        this.accountRepository = accountRepository;
    }

    public MutableLiveData<Boolean> getSessionLiveData() {
        return sessionLiveData;
    }

    public void logout() {
        if (accountRepository.clearSession()) {
            sessionLiveData.postValue(true);
        }
    }
}
