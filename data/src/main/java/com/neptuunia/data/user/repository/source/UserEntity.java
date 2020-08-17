package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.user.model.HistoryUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface UserEntity {

    Single<List<HistoryUserResponse>> getHistoryUsers();
}
