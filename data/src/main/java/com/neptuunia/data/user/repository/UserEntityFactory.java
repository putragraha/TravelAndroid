package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.repository.source.MockUserEntity;
import com.neptuunia.data.user.repository.source.UserEntity;

import javax.inject.Inject;

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
