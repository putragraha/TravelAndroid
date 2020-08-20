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

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface UserEntity {

    Single<List<HistoryUserResponse>> getHistoryUsers();

    Single<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest);

    Single<ProfileUserResponse> getProfileUser(CommonRequest commonRequest);

    Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest);

    Single<CommonResponse> registerUser(RegisterUserRequest registerUserRequest);

    Single<CommonResponse> changePassword(ChangePasswordRequest changePasswordRequest);
}
