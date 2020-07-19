package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.ArmadaSettingResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version DriverRepository, v 0.0.1 19/07/20 14.18 by Putra Nugraha
 */
public interface DriverRepository {

    Single<List<ArmadaSettingResponse>> getArmadaSettings();
}
