package com.example.coostof.savingconfigmvp.mvp.views;

import com.arellomobile.mvp.MvpView;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;
import com.example.coostof.savingconfigmvp.ui.adapters.TabsAdapter;

public interface FirstTabView extends MvpView {

    void setAdapter(TabsAdapter adapter);

    void internetError();

    void itemClickList(PetsData petsData, int position);
}
