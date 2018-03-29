package com.example.coostof.savingconfigmvp.mvp.presenters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.InjectViewState;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.mvp.views.MainView;
import com.example.coostof.savingconfigmvp.net.RequestsService;

import javax.inject.Inject;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainView> {

    private int tabPos = 0;
    private boolean itemFragmentShow;

    @Inject
    RequestsService requestsService;

    public MainActivityPresenter() {
        SavingConfigMvpApp.getAppComponent().inject(this);
    }

    public void setFragment(FragmentTransaction transaction, Fragment fragmentType) {
        itemFragmentShow = false;
        transaction.disallowAddToBackStack();
        transaction.replace(R.id.inner_container, fragmentType);
        transaction.commit();
    }

    public void openItemList(FragmentTransaction transaction, Fragment fragmentType) {
        itemFragmentShow = true;
        transaction.replace(R.id.inner_container, fragmentType);
        transaction.commit();
    }

    public void setTabPos(int position) {
        tabPos = position;
    }

    public int getTabPos() {
        return tabPos;
    }

    public boolean isItemFragmentShow() {
        return itemFragmentShow;
    }
}
