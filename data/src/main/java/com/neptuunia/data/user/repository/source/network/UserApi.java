package com.neptuunia.data.user.repository.source.network;

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
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version UserApi, v 0.0.1 20/08/20 13.57 by Putra Nugraha
 */
public interface UserApi {

    @POST("login_user.php")
    Single<LoginUserResponse> loginUser(@Body LoginUserRequest loginUserRequest);

    @POST("profile_user.php")
    Single<ProfileUserResponse> getProfileUser(@Body CommonRequest commonRequest);

    @POST("edit_profile_user.php")
    Single<CommonResponse> updateProfileUser(@Body EditProfileUserRequest editProfileUserRequest);

    @POST("register_user.php")
    Single<CommonResponse> registerUser(@Body RegisterUserRequest registerUserRequest);

    @POST("change_password.php")
    Single<CommonResponse> changePassword(@Body ChangePasswordRequest changePasswordRequest);

    @POST("get_history_user.php")
    Single<List<HistoryUserResponse>> getHistoryUsers(@Body CommonRequest commonRequest);
}
