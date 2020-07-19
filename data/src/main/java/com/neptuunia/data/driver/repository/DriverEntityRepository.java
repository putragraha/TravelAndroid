package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.ArmadaSettingResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version DriverEntityRepository, v 0.0.1 19/07/20 15.18 by Putra Nugraha
 */
public class DriverEntityRepository implements DriverRepository {

    @Inject
    DriverEntityRepository() {
        // For dagger injection
    }

    @Override
    public Single<List<ArmadaSettingResponse>> getArmadaSettings() {
        return null;
    }
}
