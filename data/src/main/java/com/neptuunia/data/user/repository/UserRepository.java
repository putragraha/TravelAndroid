package com.neptuunia.data.user.repository;

import com.neptuunia.data.user.model.HistoryUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version UserRepository, v 0.0.1 09/08/20 01.43 by Putra Nugraha
 */
public interface UserRepository {

    Single<List<HistoryUserResponse>> getHistoryUsers();
}
