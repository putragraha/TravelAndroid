package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.model.HistoryUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface UserRepository {

    Single<List<HistoryUserResponse>> getHistoryUsers();
}
