package com.neptuunia.travel.common;

import com.neptuunia.travel.historydriver.HistoryDriverViewModel;
import com.neptuunia.travel.historyuser.HistoryUserViewModel;
import com.neptuunia.travel.searchticket.SearchTicketViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private HistoryDriverViewModel historyDriverViewModel;

    private HistoryUserViewModel historyUserViewModel;

    private SearchTicketViewModel searchTicketViewModel;

    @Inject
    public ViewModelFactory(
        HistoryDriverViewModel historyDriverViewModel,
        HistoryUserViewModel historyUserViewModel,
        SearchTicketViewModel searchTicketViewModel
    ) {
        this.historyDriverViewModel = historyDriverViewModel;
        this.historyUserViewModel = historyUserViewModel;
        this.searchTicketViewModel = searchTicketViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HistoryDriverViewModel.class)) {
            //noinspection unchecked
            return (T) historyDriverViewModel;
        } else if (modelClass.isAssignableFrom(HistoryUserViewModel.class)) {
            //noinspection unchecked
            return (T) historyUserViewModel;
        } else if (modelClass.isAssignableFrom(SearchTicketViewModel.class)) {
            //noinspection unchecked
            return (T) searchTicketViewModel;
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
