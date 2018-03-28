package com.example.coostof.savingconfigmvp.di.components;

import com.example.coostof.savingconfigmvp.di.modules.AppModule;
import com.example.coostof.savingconfigmvp.di.modules.ContextModule;
import com.example.coostof.savingconfigmvp.mvp.presenters.FirstTabPresenter;
import com.example.coostof.savingconfigmvp.mvp.presenters.MainActivityPresenter;
import com.example.coostof.savingconfigmvp.mvp.presenters.SecondTabPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ContextModule.class})
public interface AppComponent {

    void inject(MainActivityPresenter mainActivityPresenter);

    void inject(FirstTabPresenter firstPresenter);

    void inject(SecondTabPresenter secondPresenter);
}
