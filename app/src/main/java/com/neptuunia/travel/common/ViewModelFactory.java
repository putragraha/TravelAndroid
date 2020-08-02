package com.neptuunia.travel.common;

import com.neptuunia.travel.historydriver.HistoryDriverViewModel;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author nSystem
 * @version ViewModelFactory, v 0.0.1 31/07/20 10.11 by nSystem
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private HistoryDriverViewModel historyDriverViewModel;

    @Inject
    public ViewModelFactory(HistoryDriverViewModel historyDriverViewModel) {
        this.historyDriverViewModel = historyDriverViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HistoryDriverViewModel.class)) {
            //noinspection unchecked
            return (T) historyDriverViewModel;
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
