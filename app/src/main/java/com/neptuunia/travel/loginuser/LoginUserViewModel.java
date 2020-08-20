package com.neptuunia.travel.loginuser;

import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.repository.UserRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version LoginUserViewModel, v 0.0.1 18/08/20 08.32 by Putra Nugraha
 */
public class LoginUserViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> successLiveData = new MutableLiveData<>();

    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    private UserRepository userRepository;

    @Inject
    public LoginUserViewModel(
        @NonNull Application application,
        UserRepository userRepository
    ) {
        super(application);
        this.userRepository = userRepository;
    }

    public MutableLiveData<Boolean> getSuccessLiveData() {
        return successLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }

    public void loginUser(String email, String password) {
        userRepository.loginUser(email, password)
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<LoginUserResponse>(){

                @Override
                public void onSuccess(LoginUserResponse loginUserResponse) {
                    super.onSuccess(loginUserResponse);

                    if (loginUserResponse.isSuccess()) {
                        successLiveData.postValue(loginUserResponse.isSuccess());
                    } else {
                        errorLiveData.postValue("");
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                    super.onError(throwable);
                    errorLiveData.postValue(throwable.getMessage());
                }
            });
    }
}
