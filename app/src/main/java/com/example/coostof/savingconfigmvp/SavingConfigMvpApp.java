package com.example.coostof.savingconfigmvp;

import android.app.Application;
import android.content.Context;

import com.example.coostof.savingconfigmvp.di.components.AppComponent;
import com.example.coostof.savingconfigmvp.di.components.DaggerAppComponent;
import com.example.coostof.savingconfigmvp.di.modules.ContextModule;

public class SavingConfigMvpApp extends Application {

    private static SavingConfigMvpApp mContext;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;

        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static SavingConfigMvpApp getContext() {
        return mContext;
    }
}
