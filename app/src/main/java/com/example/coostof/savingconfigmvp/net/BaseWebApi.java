package com.example.coostof.savingconfigmvp.net;

import com.example.coostof.savingconfigmvp.mvp.models.PetsGeneral;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BaseWebApi {

    @GET("api.php")
    Observable<PetsGeneral> getPets(
            @Query("query") String pets);
}
