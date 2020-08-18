package com.neptuunia.data.driver.repository.source.network;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version DriverApi, v 0.0.1 17/08/20 21.39 by Putra Nugraha
 */
public interface DriverApi {

    @POST("login_driver.php")
    Single<Boolean> loginDriver(@Field("email") String email, @Field("password") String password);
}
