package com.neptuunia.data.armada.repository.source;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaEntity, v 0.0.1 20/08/20 10.33 by Putra Nugraha
 */
public interface ArmadaEntity {

    Single<CommonResponse> addArmada(AddArmadaRequest addArmadaRequest);
}
