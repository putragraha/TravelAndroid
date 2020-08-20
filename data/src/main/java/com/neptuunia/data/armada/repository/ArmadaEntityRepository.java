package com.neptuunia.data.armada.repository;

import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.armada.model.request.AddArmadaRequest;
import com.neptuunia.data.armada.repository.source.ArmadaEntity;
import com.neptuunia.data.constant.Source;
import com.neptuunia.data.model.CommonResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ArmadaEntityRepository, v 0.0.1 20/08/20 10.43 by Putra Nugraha
 */
public class ArmadaEntityRepository implements ArmadaRepository {

    private AccountRepository accountRepository;

    private ArmadaEntityFactory armadaEntityFactory;

    @Inject
    public ArmadaEntityRepository(
        AccountRepository accountRepository,
        ArmadaEntityFactory armadaEntityFactory
    ) {
        this.accountRepository = accountRepository;
        this.armadaEntityFactory = armadaEntityFactory;
    }

    @Override
    public Single<CommonResponse> addArmada(AddArmadaRequest addArmadaRequest) {
        addArmadaRequest.setDriverId(accountRepository.getSession().getId());
        addArmadaRequest.setArmadaClass("");

        return createNetworkArmadaEntity()
            .addArmada(addArmadaRequest);
    }

    private ArmadaEntity createNetworkArmadaEntity() {
        return armadaEntityFactory.createArmadaEntity(Source.NETWORK);
    }
}
