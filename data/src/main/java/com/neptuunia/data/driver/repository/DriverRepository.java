package com.neptuunia.data.driver.repository;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.model.LoginDriverResponse;
import com.neptuunia.data.driver.model.ProfileDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverRepository {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();

    Single<ProfileDriverResponse> getProfileDriver();

    Single<LoginDriverResponse> loginDriver(String email, String password);
}
