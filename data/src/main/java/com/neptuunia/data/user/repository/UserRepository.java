package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface UserRepository {

    Single<List<HistoryUserResponse>> getHistoryUsers();

    Single<LoginUserResponse> loginDriver(String email, String password);
}
