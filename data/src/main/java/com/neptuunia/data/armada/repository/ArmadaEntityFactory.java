package com.neptuunia.data.armada.repository;

import com.neptuunia.data.armada.repository.source.ArmadaEntity;
import com.neptuunia.data.armada.repository.source.NetworkArmadaEntity;
import com.neptuunia.data.constant.Source;

import javax.inject.Inject;

public class ArmadaEntityFactory {

    private NetworkArmadaEntity networkArmadaEntity;

    @Inject
    public ArmadaEntityFactory(NetworkArmadaEntity networkArmadaEntity) {
        this.networkArmadaEntity = networkArmadaEntity;
    }

    public ArmadaEntity createArmadaEntity(@Source String source) {
        return networkArmadaEntity;
    }
}
