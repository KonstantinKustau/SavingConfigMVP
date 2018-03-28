package com.example.coostof.savingconfigmvp.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.mvp.views.MainView;
import com.example.coostof.savingconfigmvp.net.RequestsService;

import javax.inject.Inject;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainView> {

    @Inject
    RequestsService requestsService;

    public MainActivityPresenter() {
        SavingConfigMvpApp.getAppComponent().inject(this);
    }
}
