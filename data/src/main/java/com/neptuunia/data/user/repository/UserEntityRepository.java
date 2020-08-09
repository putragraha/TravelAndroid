package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.model.HistoryUserResponse;
import com.neptuunia.data.user.repository.source.UserEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version UserEntityRepository, v 0.0.1 09/08/20 01.44 by Putra Nugraha
 */
public class UserEntityRepository implements UserRepository {

    private UserEntityFactory userEntityFactory;

    @Inject
    public UserEntityRepository(UserEntityFactory userEntityFactory) {
        this.userEntityFactory = userEntityFactory;
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers() {
        return createUserEntity()
            .getHistoryUsers();
    }

    public UserEntity createUserEntity() {
        return userEntityFactory.createUserEntity();
    }
}
