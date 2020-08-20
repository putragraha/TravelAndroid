package com.neptuunia.data.armada.repository.source;

import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.armada.repository.source.network.ArmadaApi;
import com.neptuunia.data.model.CommonResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version NetworkArmadaEntity, v 0.0.1 20/08/20 10.40 by Putra Nugraha
 */
public class NetworkArmadaEntity implements ArmadaEntity {

    private ArmadaApi armadaApi;

    @Inject
    public NetworkArmadaEntity(Retrofit retrofit) {
        armadaApi = retrofit.create(ArmadaApi.class);
    }

    @Override
    public Single<CommonResponse> addArmada(AddArmadaRequest addArmadaRequest) {
        return armadaApi.addArmada(addArmadaRequest);
    }
}
