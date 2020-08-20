package com.neptuunia.data.driver.repository.source.network;

import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version DriverApi, v 0.0.1 17/08/20 21.39 by Putra Nugraha
 */
public interface DriverApi {

    @POST("login_driver.php")
    Single<LoginDriverResponse> loginDriver(@Body LoginDriverRequest loginDriverRequest);

    @POST("profile_driver.php")
    Single<ProfileDriverResponse> getProfileDriver(@Body CommonRequest commonRequest);

    @POST("edit_profile_driver.php")
    Single<CommonResponse> updateProfileDriver(@Body EditProfileDriverRequest editProfileDriverRequest);
}
