package com.example.coostof.savingconfigmvp.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;

public interface MainView extends MvpView {

    void itemClickList(PetsData petsData, int position);
}
