package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.data.driver.model.LoginDriverRequest;
import com.neptuunia.data.driver.model.LoginDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverEntity {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();

    Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest);
}
