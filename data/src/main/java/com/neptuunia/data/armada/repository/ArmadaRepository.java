package com.neptuunia.data.armada.repository;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.model.CommonResponse;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaRepository, v 0.0.1 20/08/20 10.42 by Putra Nugraha
 */
public interface ArmadaRepository {

    Single<CommonResponse> addArmada(AddArmadaRequest addArmadaRequest);
}
