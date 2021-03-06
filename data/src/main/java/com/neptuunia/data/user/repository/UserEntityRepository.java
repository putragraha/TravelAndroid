package com.neptuunia.data.user.repository;

import com.neptuunia.data.account.model.Account;
import com.neptuunia.data.account.repository.AccountRepository;
import com.neptuunia.data.constant.AccountType;
import com.neptuunia.data.constant.Source;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.ChangePasswordRequest;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.request.LoginUserRequest;
import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.model.response.ProfileUserResponse;
import com.neptuunia.data.user.repository.source.UserEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class UserEntityRepository implements UserRepository {

    private UserEntityFactory userEntityFactory;

    private AccountRepository accountRepository;

    @Inject
    public UserEntityRepository(
        UserEntityFactory userEntityFactory,
        AccountRepository accountRepository
    ) {
        this.userEntityFactory = userEntityFactory;
        this.accountRepository = accountRepository;
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers() {
        return createUserEntity(Source.NETWORK)
            .getHistoryUsers(new CommonRequest(accountRepository.getSession().getId()));
    }

    @Override
    public Single<LoginUserResponse> loginUser(String email, String password) {
        return createUserEntity(Source.NETWORK)
            .loginUser(new LoginUserRequest(email, password))
            .doOnSuccess(this::saveSession);
    }

    @Override
    public Single<ProfileUserResponse> getProfileUser() {
        return createUserEntity(Source.NETWORK)
            .getProfileUser(new CommonRequest(accountRepository.getSession().getId()));
    }

    @Override
    public Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest) {
        editProfileUserRequest.setId(accountRepository.getSession().getId());

        return createUserEntity(Source.NETWORK)
            .updateProfileUser(editProfileUserRequest);
    }

    @Override
    public Single<CommonResponse> registerUser(RegisterUserRequest registerUserRequest) {
        return createUserEntity(Source.NETWORK)
            .registerUser(registerUserRequest);
    }

    @Override
    public Single<CommonResponse> changePassword(String newPassword, String oldPassword) {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setId(accountRepository.getSession().getId());
        changePasswordRequest.setNewPassword(newPassword);
        changePasswordRequest.setOldPassword(oldPassword);

        return createUserEntity(Source.NETWORK)
            .changePassword(changePasswordRequest);
    }

    public UserEntity createUserEntity(@Source String source) {
        return userEntityFactory.createUserEntity(source);
    }

    private void saveSession(LoginUserResponse loginUserResponse) {
        accountRepository.saveSession(new Account(loginUserResponse.getId(), AccountType.USER));
    }
}
