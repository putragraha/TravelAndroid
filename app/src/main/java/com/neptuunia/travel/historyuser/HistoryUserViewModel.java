package com.neptuunia.travel.historyuser;

import com.neptuunia.data.user.model.response.HistoryUserResponse;
import com.neptuunia.data.user.repository.UserRepository;
import com.neptuunia.travel.utils.AutoDisposeSingleObserver;
import com.neptuunia.travel.utils.Transformer;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HistoryUserViewModel extends AndroidViewModel {

    private final MutableLiveData<List<HistoryUserResponse>> historyUserResponseLiveData =
        new MutableLiveData<>();

    private final UserRepository userRepository;

    private List<HistoryUserResponse> historyUserResponses = new ArrayList<>();

    @Inject
    public HistoryUserViewModel(
        @NonNull Application application,
        UserRepository userRepository
    ) {
        super(application);
        this.userRepository = userRepository;
        fetchHistoryUsers();
    }

    public LiveData<List<HistoryUserResponse>> getHistoryUsers() {
        return historyUserResponseLiveData;
    }

    public void filterHistoryUsers(long minDate, long maxDate) {
        List<HistoryUserResponse> results = new ArrayList<>();

        for (HistoryUserResponse historyUserResponse : historyUserResponses) {
            long datetime = Long.parseLong(historyUserResponse.getDatetime());

            if (datetime >= minDate && datetime <= maxDate) {
                results.add(historyUserResponse);
            }
        }

        historyUserResponseLiveData.postValue(results);
    }

    public void clearHistoryUsers() {
        historyUserResponseLiveData.postValue(historyUserResponses);
    }

    private void fetchHistoryUsers() {
        userRepository.getHistoryUsers()
            .compose(Transformer::applySchedulers)
            .subscribe(new AutoDisposeSingleObserver<List<HistoryUserResponse>>() {

                @Override
                public void onSuccess(@NonNull List<HistoryUserResponse> historyUserResponses) {
                    super.onSuccess(historyUserResponses);
                    HistoryUserViewModel.this.historyUserResponses = historyUserResponses;
                    historyUserResponseLiveData.postValue(historyUserResponses);
                }
            });
    }
}