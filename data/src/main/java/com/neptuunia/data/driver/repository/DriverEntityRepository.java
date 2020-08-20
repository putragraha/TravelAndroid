package com.neptuunia.data.driver.repository;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.constant.AccountType;
import com.neptuunia.data.constant.Source;
import com.neptuunia.data.driver.model.request.EditProfileDriverRequest;
import com.neptuunia.data.driver.model.response.HistoryDriverResponse;
import com.neptuunia.data.driver.model.request.LoginDriverRequest;
import com.neptuunia.data.driver.model.response.LoginDriverResponse;
import com.neptuunia.data.driver.model.response.ProfileDriverResponse;
import com.neptuunia.data.driver.repository.source.DriverEntity;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class DriverEntityRepository implements DriverRepository {

    private DriverEntityFactory driverEntityFactory;

    private AccountRepository accountRepository;

    @Inject
    public DriverEntityRepository(
        AccountRepository accountRepository,
        DriverEntityFactory driverEntityFactory
    ) {
        this.accountRepository = accountRepository;
        this.driverEntityFactory = driverEntityFactory;
    }

    @Override
    public Single<List<HistoryDriverResponse>> getHistoryDrivers() {
        return createDriverEntity(Source.NETWORK)
            .getHistoryDrivers(new CommonRequest(accountRepository.getSession().getId()));
    }

    @Override
    public Single<ProfileDriverResponse> getProfileDriver() {
        return createDriverEntity(Source.NETWORK)
            .getProfileDriver(new CommonRequest(accountRepository.getSession().getId()));
    }

    @Override
    public Single<LoginDriverResponse> loginDriver(String email, String password) {
        return createDriverEntity(Source.NETWORK)
            .loginDriver(new LoginDriverRequest(email, password))
            .doOnSuccess(this::saveSession);
    }

    @Override
    public Single<CommonResponse> updateProfileDriver(String name, String phoneNumber) {
        EditProfileDriverRequest editProfileDriverRequest = new EditProfileDriverRequest();
        editProfileDriverRequest.setId(accountRepository.getSession().getId());
        editProfileDriverRequest.setName(name);
        editProfileDriverRequest.setPhoneNumber(phoneNumber);

        return createDriverEntity(Source.NETWORK)
            .updateProfileDriver(editProfileDriverRequest);
    }

    public DriverEntity createDriverEntity(@Source String source) {
        return driverEntityFactory.createDriverEntity(source);
    }

    private void saveSession(LoginDriverResponse loginDriverResponse) {
        accountRepository.saveSession(new Account(loginDriverResponse.getId(), AccountType.DRIVER));
    }
}
