package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.ChangePasswordRequest;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.request.LoginUserRequest;
import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.model.response.ProfileUserResponse;
import com.neptuunia.data.user.repository.source.network.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

public class NetworkUserEntity implements UserEntity {

    private UserApi userApi;

    @Inject
    public NetworkUserEntity(Retrofit retrofit) {
        this.userApi = retrofit.create(UserApi.class);
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers(CommonRequest commonRequest) {
        return Single.defer(() -> userApi.getHistoryUsers(commonRequest));
    }

    @Override
    public Single<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest) {
        return Single.defer(() -> userApi.loginUser(loginUserRequest));
    }

    @Override
    public Single<ProfileUserResponse> getProfileUser(CommonRequest commonRequest) {
        return Single.defer(() -> userApi.getProfileUser(commonRequest));
    }

    @Override
    public Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest) {
        return Single.defer(() -> userApi.updateProfileUser(editProfileUserRequest));
    }

    @Override
    public Single<CommonResponse> registerUser(RegisterUserRequest registerUserRequest) {
        return Single.defer(() -> userApi.registerUser(registerUserRequest));
    }

    @Override
    public Single<CommonResponse> changePassword(ChangePasswordRequest changePasswordRequest) {
        return Single.defer(() -> userApi.changePassword(changePasswordRequest));
    }
}
