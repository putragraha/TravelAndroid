package com.neptuunia.data.driver.repository.source;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface DriverEntity {

    Single<List<HistoryDriverResponse>> getHistoryDrivers();

    Single<ProfileDriverResponse> getProfileDriver(Account account);

    Single<LoginDriverResponse> loginDriver(LoginDriverRequest loginDriverRequest);
}
