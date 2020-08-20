package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverEntity {

    Single<List<HistoryDriverResponse>> getHistoryDrivers(CommonRequest commonRequest);

    Single<ProfileDriverResponse> getProfileDriver(CommonRequest commonRequest);

    Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest);

    Single<CommonResponse> updateProfileDriver(EditProfileDriverRequest editProfileDriverRequest);
}
