package com.neptuunia.travel.di;

import com.neptuunia.data.driver.model.HistoryDriverResponse;
import com.neptuunia.travel.common.ViewModelFactory;
import com.neptuunia.travel.constant.Variable;
import com.neptuunia.travel.historydriver.HistoryDriverActivity;
import com.neptuunia.travel.historydriver.HistoryDriverViewModel;
import com.neptuunia.travel.orderdetaildriver.OrderDetailDriverActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.core.util.Consumer;
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

    @Provides
    Consumer<HistoryDriverResponse> provideHistoryDriverResponseConsumer(
        @ActivityContext Context context
    ) {
        return historyDriverResponse -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Variable.HISTORY_DRIVER_RESPONSE_DATA, historyDriverResponse);

            ((HistoryDriverActivity) context).startActivityWithBundle(
                OrderDetailDriverActivity.class,
                bundle
            );
        };
    }
}
