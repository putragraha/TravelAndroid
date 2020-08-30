package com.neptuunia.data.armada.repository.source.network;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ArmadaApi {

    @POST("add_armada_setting.php")
    Single<CommonResponse> addArmada(@Body AddArmadaRequest addArmadaRequest);
}
