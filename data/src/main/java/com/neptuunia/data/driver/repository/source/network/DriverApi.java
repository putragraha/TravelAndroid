package com.neptuunia.data.driver.repository.source.network;

import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DriverApi {

    @POST("get_history_driver.php")
    Single<List<HistoryDriverResponse>> getHistoryDrivers(@Body CommonRequest commonRequest);

    @POST("login_driver.php")
    Single<LoginDriverResponse> loginDriver(@Body LoginDriverRequest loginDriverRequest);

    @POST("profile_driver.php")
    Single<ProfileDriverResponse> getProfileDriver(@Body CommonRequest commonRequest);

    @POST("edit_profile_driver.php")
    Single<CommonResponse> updateProfileDriver(@Body EditProfileDriverRequest editProfileDriverRequest);
}
