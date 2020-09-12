package com.neptuunia.data.user.repository.source;

import com.neptuunia.data.constant.TicketStatus;
import com.neptuunia.data.model.CommonRequest;
import com.neptuunia.data.model.CommonResponse;
import com.neptuunia.data.user.model.request.ChangePasswordRequest;
import com.neptuunia.data.user.model.request.EditProfileUserRequest;
import com.neptuunia.data.user.model.request.LoginUserRequest;
import com.neptuunia.data.user.model.request.RegisterUserRequest;
import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.model.response.LoginUserResponse;
import com.neptuunia.data.user.model.response.ProfileUserResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class MockUserEntity implements UserEntity {

    @Inject
    public MockUserEntity() {
        // For dagger injection
    }

    @Override
    public Single<List<HistoryUserResponse>> getHistoryUsers(CommonRequest commonRequest) {
        List<HistoryUserResponse> historyUserResponses = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            HistoryUserResponse historyUserResponse = new HistoryUserResponse();
            historyUserResponse.setOrderCode("Code" + i);
            historyUserResponse.setGroup("Group: " + i);
            historyUserResponse.setDeparture("Departure: " + i);
            historyUserResponse.setArrival("Arrival: " + i);
            historyUserResponse.setArmadaClass("Armada Class: " + i);
            historyUserResponse.setPhotoName("PhotoUrl" + i);
            historyUserResponse.setDriverName("DriverName " + i);
            historyUserResponse.setDriverPhoneNumber("Driver Phone Number " + i);
            historyUserResponse.setSeatBooked(i + " seat booked");
            historyUserResponse.setTotalPrice(i * 120000);
            historyUserResponse.setDatetime("Departure Time: " + i);
            historyUserResponse.setLatitude("Latitude:" + i);
            historyUserResponse.setLongitude("Longitude:" + i);
            historyUserResponse.setStatus(TicketStatus.PENDING);
            historyUserResponse.setNote("Note" + i);

            historyUserResponses.add(historyUserResponse);
        }

        return Single.just(historyUserResponses);
    }

    @Override
    public Single<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest) {
        return Single.just(new LoginUserResponse());
    }

    @Override
    public Single<ProfileUserResponse> getProfileUser(CommonRequest commonRequest) {
        return Single.just(new ProfileUserResponse());
    }

    @Override
    public Single<CommonResponse> updateProfileUser(EditProfileUserRequest editProfileUserRequest) {
        return Single.just(new CommonResponse());
    }

    @Override
    public Single<CommonResponse> registerUser(RegisterUserRequest registerUserRequest) {
        return Single.just(new CommonResponse());
    }

    @Override
    public Single<CommonResponse> changePassword(ChangePasswordRequest changePasswordRequest) {
        return Single.just(new CommonResponse());
    }
}
