package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.request.LoginUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.model.response.ProfileUserResponse;
import com.neptuunia.data.user.repository.source.network.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NetworkUserEntity, v 0.0.1 20/08/20 13.59 by Putra Nugraha
 */
public class NetworkUserEntity implements UserEntity {

    private UserApi userApi;

    @Inject
    public NetworkUserEntity(Retrofit retrofit) {
        this.userApi = retrofit.create(UserApi.class);
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers() {
        // TODO (Putra): 20/08/20 Get History User here
        throw new UnsupportedOperationException("Will support later");
    }

    @Override
    public Single<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest) {
        return userApi.loginUser(loginUserRequest);
    }

    @Override
    public Single<ProfileUserResponse> getProfileUser(CommonRequest commonRequest) {
        return userApi.getProfileUser(commonRequest);
    }

    @Override
    public Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest) {
        return userApi.updateProfileUser(editProfileUserRequest);
    }
}
