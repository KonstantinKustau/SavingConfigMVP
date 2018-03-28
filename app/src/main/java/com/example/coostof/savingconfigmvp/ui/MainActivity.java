package com.example.coostof.savingconfigmvp.ui;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.mvp.presenters.MainActivityPresenter;
import com.example.coostof.savingconfigmvp.mvp.views.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
