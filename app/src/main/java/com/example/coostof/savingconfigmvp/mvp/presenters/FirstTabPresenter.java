package com.example.coostof.savingconfigmvp.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.mvp.views.FirstTabView;
import com.example.coostof.savingconfigmvp.net.RequestsService;

import javax.inject.Inject;

@InjectViewState
public class FirstTabPresenter extends BasePresenter<FirstTabView> {

    @Inject
    RequestsService requestsService;

    public FirstTabPresenter() {
        SavingConfigMvpApp.getAppComponent().inject(this);
    }
}
