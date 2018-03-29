package com.example.coostof.savingconfigmvp.mvp.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private CompositeDisposable compositeDisposable;

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Using clear will clear all, but can accept new disposable
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    void addDisposable(@NonNull final Disposable disposable) {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
