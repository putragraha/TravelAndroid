package com.neptuunia.travel.common;

import com.neptuunia.travel.armadasetting.ArmadaSettingViewModel;
import com.neptuunia.travel.historydriver.HistoryDriverViewModel;
import com.neptuunia.travel.historyuser.HistoryUserViewModel;
import com.neptuunia.travel.homedriver.HomeDriverViewModel;
import com.neptuunia.travel.homeuser.HomeUserViewModel;
import com.neptuunia.travel.logindriver.LoginDriverViewModel;
import com.neptuunia.travel.loginuser.LoginUserViewModel;
import com.neptuunia.travel.onboarding.MainViewModel;
import com.neptuunia.travel.profiledriver.ProfileDriverViewModel;
import com.neptuunia.travel.profileuser.ProfileUserViewModel;
import com.neptuunia.travel.searchticket.SearchTicketViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    HistoryDriverViewModel historyDriverViewModel;

    @Inject
    LoginDriverViewModel loginDriverViewModel;

    @Inject
    HistoryUserViewModel historyUserViewModel;

    @Inject
    SearchTicketViewModel searchTicketViewModel;

    @Inject
    MainViewModel mainViewModel;

    @Inject
    HomeDriverViewModel homeDriverViewModel;

    @Inject
    ProfileDriverViewModel profileDriverViewModel;

    @Inject
    ArmadaSettingViewModel armadaSettingViewModel;

    @Inject
    LoginUserViewModel loginUserViewModel;

    @Inject
    HomeUserViewModel homeUserViewModel;

    @Inject
    ProfileUserViewModel profileUserViewModel;

    @Inject
    public ViewModelFactory() {
        // For hilt injection
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HistoryDriverViewModel.class)) {
            //noinspection unchecked
            return (T) historyDriverViewModel;
        } else if (modelClass.isAssignableFrom(LoginDriverViewModel.class)) {
            //noinspection unchecked
            return (T) loginDriverViewModel;
        } else if (modelClass.isAssignableFrom(HistoryUserViewModel.class)) {
            //noinspection unchecked
            return (T) historyUserViewModel;
        } else if (modelClass.isAssignableFrom(SearchTicketViewModel.class)) {
            //noinspection unchecked
            return (T) searchTicketViewModel;
        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) mainViewModel;
        } else if (modelClass.isAssignableFrom(HomeDriverViewModel.class)) {
            //noinspection unchecked
            return (T) homeDriverViewModel;
        } else if (modelClass.isAssignableFrom(ProfileDriverViewModel.class)) {
            //noinspection unchecked
            return (T) profileDriverViewModel;
        } else if (modelClass.isAssignableFrom(ArmadaSettingViewModel.class)) {
            //noinspection unchecked
            return (T) armadaSettingViewModel;
        } else if (modelClass.isAssignableFrom(LoginUserViewModel.class)) {
            //noinspection unchecked
            return (T) loginUserViewModel;
        } else if (modelClass.isAssignableFrom(HomeUserViewModel.class)) {
            //noinspection unchecked
            return (T) homeUserViewModel;
        } else if (modelClass.isAssignableFrom(ProfileUserViewModel.class)) {
            //noinspection unchecked
            return (T) profileUserViewModel;
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
