package com.neptuunia.data.armada.repository.source;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;

public interface ArmadaEntity {

    Single<CommonResponse> addArmada(AddArmadaRequest addArmadaRequest);
}
