package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.driver.repository.source.network.DriverApi;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NetworkDriverEntity, v 0.0.1 17/08/20 21.51 by Putra Nugraha
 */
public class NetworkDriverEntity implements DriverEntity {

    private DriverApi driverApi;

    @Inject
    public NetworkDriverEntity(Retrofit retrofit) {
        this.driverApi = retrofit.create(DriverApi.class);
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers(CommonRequest commonRequest) {
        return driverApi.getHistoryDrivers(commonRequest);
    }

    @Override
    public Single<ProfileDriverResponse> getProfileDriver(CommonRequest commonRequest) {
        return driverApi.getProfileDriver(commonRequest);
    }

    @Override
    public Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest) {
        return driverApi.loginDriver(loginDriverRequest);
    }

    @Override
    public Single<CommonResponse> updateProfileDriver(
        EditProfileDriverRequest editProfileDriverRequest
    ) {
        return driverApi.updateProfileDriver(editProfileDriverRequest);
    }
}
