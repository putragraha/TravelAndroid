package com.neptuunia.data.armada.repository.source.network;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaApi, v 0.0.1 20/08/20 10.30 by Putra Nugraha
 */
public interface ArmadaApi {

    @POST("add_armada_setting.php")
    Single<CommonResponse> addArmada(@Body AddArmadaRequest addArmadaRequest);
}
