package com.neptuunia.travel.di;

import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;
import com.neptuunia.travel.historydriver.HistoryDriverViewModel;

import android.content.Context;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version HistoryDriverActivityModule, v 0.0.1 02/08/20 07.52 by Putra Nugraha
 */
@Module
@InstallIn(ActivityComponent.class)
public class HistoryDriverActivityModule {

    @Provides
    LinearLayoutManager provideLinearLayoutManager(@ActivityContext Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    ViewModelFactory provideViewModelFactory(HistoryDriverViewModel historyDriverViewModel) {
        return new ViewModelFactory(historyDriverViewModel);
    }

    @Provides
    ViewModelProvider provideViewModelProvider(
        @ActivityContext Context context,
        ViewModelFactory viewModelFactory
    ) {
        return new ViewModelProvider((HistoryDriverActivity) context, viewModelFactory);
    }
}
