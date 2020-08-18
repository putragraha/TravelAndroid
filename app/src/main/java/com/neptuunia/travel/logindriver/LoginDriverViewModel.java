package com.neptuunia.travel.logindriver;

import com.neptuunia.data.driver.repository.DriverRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginDriverViewModel, v 0.0.1 18/08/20 08.32 by Putra Nugraha
 */
public class LoginDriverViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> loginResponseLiveData =
        new MutableLiveData<>();

    private DriverRepository driverRepository;

    @Inject
    public LoginDriverViewModel(
        @NonNull Application application,
        DriverRepository driverRepository
    ) {
        super(application);
        this.driverRepository = driverRepository;
    }

    public MutableLiveData<Boolean> getLoginResponseLiveData() {
        return loginResponseLiveData;
    }

    public void loginDriver(String email, String password) {
        driverRepository.loginDriver(email, password)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<Boolean>(){

                @Override
                public void onSuccess(Boolean success) {
                    super.onSuccess(success);
                    loginResponseLiveData.postValue(success);
                }
            });
    }
}
