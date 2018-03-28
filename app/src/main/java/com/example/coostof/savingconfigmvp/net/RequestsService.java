package com.example.coostof.savingconfigmvp.net;

import com.example.coostof.savingconfigmvp.mvp.models.PetsGeneral;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RequestsService {

    private final BaseWebApi baseWebApi;

    @Inject
    public RequestsService(final BaseWebApi baseWebApi) {
        this.baseWebApi = baseWebApi;
    }

    public Observable<PetsGeneral> getPets(String petType) {
        return baseWebApi.getPets(petType);
    }
}
