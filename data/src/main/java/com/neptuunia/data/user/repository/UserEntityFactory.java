package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.repository.source.MockUserEntity;
import com.neptuunia.data.user.repository.source.UserEntity;

import javax.inject.Inject;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version UserEntityFactory, v 0.0.1 09/08/20 01.44 by Putra Nugraha
 */
public class UserEntityFactory {

    private MockUserEntity mockUserEntity;

    @Inject
    public UserEntityFactory(MockUserEntity mockUserEntity) {
        this.mockUserEntity = mockUserEntity;
    }

    public UserEntity createUserEntity() {
        return mockUserEntity;
    }
}
