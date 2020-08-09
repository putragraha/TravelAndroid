package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.user.model.HistoryUserResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version UserEntity, v 0.0.1 09/08/20 01.45 by Putra Nugraha
 */
public interface UserEntity {

    Single<List<HistoryUserResponse>> getHistoryUsers();
}
