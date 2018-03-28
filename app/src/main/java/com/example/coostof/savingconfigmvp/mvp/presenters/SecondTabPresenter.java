package com.example.coostof.savingconfigmvp.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.mvp.views.SecondTabView;
import com.example.coostof.savingconfigmvp.net.RequestsService;

import javax.inject.Inject;

@InjectViewState
public class SecondTabPresenter extends BasePresenter<SecondTabView> {

    @Inject
    RequestsService requestsService;

    public SecondTabPresenter() {
        SavingConfigMvpApp.getAppComponent().inject(this);
    }
}
