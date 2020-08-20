package com.neptuunia.data.user.repository;

import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.model.response.ProfileUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface UserRepository {

    Single<List<HistoryUserResponse>> getHistoryUsers();

    Single<LoginUserResponse> loginUser(String email, String password);

    Single<ProfileUserResponse> getProfileUser();

    Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest);
}
