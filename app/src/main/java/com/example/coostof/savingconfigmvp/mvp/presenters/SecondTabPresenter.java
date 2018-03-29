package com.example.coostof.savingconfigmvp.mvp.presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.coostof.savingconfigmvp.R;
import com.example.coostof.savingconfigmvp.SavingConfigMvpApp;
import com.example.coostof.savingconfigmvp.common.Constants;
import com.example.coostof.savingconfigmvp.mvp.models.PetsData;
import com.example.coostof.savingconfigmvp.mvp.views.SecondTabView;
import com.example.coostof.savingconfigmvp.net.RequestsService;
import com.example.coostof.savingconfigmvp.ui.adapters.TabsAdapter;
import com.example.coostof.savingconfigmvp.utils.PrefUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SecondTabPresenter extends BasePresenter<SecondTabView> {

    @Inject
    RequestsService requestsService;

    private TabsAdapter mAdapter;

    public SecondTabPresenter() {
        SavingConfigMvpApp.getAppComponent().inject(this);
    }

    public void setPetsInAdapter() {

        Disposable disposable = requestsService.getPets(SavingConfigMvpApp.getContext().getResources().getString(R.string.request_pet_dog))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pets -> {
                    Log.d(Constants.MAIN_LOG_TAG, "FirstTabPresenter: getPets() success");
                    createAdapter(pets.getData());
                }, throwable -> {
                    Log.e(Constants.MAIN_LOG_TAG, "FirstTabPresenter: getPets() throwable = " + throwable);
                    getViewState().internetError();
                });
        addDisposable(disposable);
    }

    private void createAdapter(List<PetsData> petsList) {
        TabsAdapter.RecyclerViewClickListener listener = (view1, position) -> {
            Log.d(Constants.MAIN_LOG_TAG, "item click. position = " + position);
            getViewState().itemClickList(mAdapter.getItemByPosition(position), position);
        };
        if (petsList != null) {
            mAdapter = new TabsAdapter(listener, petsList);
            getViewState().setAdapter(mAdapter);
        }
    }

    public void setLastListPosition(int position) {
        PrefUtils.setSecondScrollPosition(position);
    }

    public int getLastListPosition() {
        return PrefUtils.getSecondScrollPosition();
    }
}
