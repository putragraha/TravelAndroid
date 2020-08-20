package com.neptuunia.data.user.repository;

import com.neptuunia.data.constant.Source;
import com.neptuunia.data.user.repository.source.MockUserEntity;
import com.neptuunia.data.user.repository.source.NetworkUserEntity;
import com.neptuunia.data.user.repository.source.UserEntity;

import javax.inject.Inject;

public class UserEntityFactory {

    private MockUserEntity mockUserEntity;

    private NetworkUserEntity networkUserEntity;

    @Inject
    public UserEntityFactory(MockUserEntity mockUserEntity, NetworkUserEntity networkUserEntity) {
        this.mockUserEntity = mockUserEntity;
        this.networkUserEntity = networkUserEntity;
    }

    public UserEntity createUserEntity(@Source String source) {
        if (Source.NETWORK.equals(source)) {
            return networkUserEntity;
        }

        return mockUserEntity;
    }
}
