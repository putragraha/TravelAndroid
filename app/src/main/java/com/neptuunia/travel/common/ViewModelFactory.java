package com.neptuunia.travel.common;

import com.neptuunia.travel.historydriver.HistoryDriverViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author Rengar
 * @version ViewModelFactory, v 0.0.1 31/07/20 10.11 by Rengar
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;

    public ViewModelFactory(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HistoryDriverViewModel.class)) {
            //noinspection unchecked
            return (T) new HistoryDriverViewModel(application);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
