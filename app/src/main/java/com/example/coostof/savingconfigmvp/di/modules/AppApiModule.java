package com.example.coostof.savingconfigmvp.di.modules;

import com.example.coostof.savingconfigmvp.common.Constants;
import com.example.coostof.savingconfigmvp.net.BaseWebApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {RetrofitModule.class})
public class AppApiModule {

    @Provides
    @Singleton
    BaseWebApi provideApi(@Named(Constants.BASE_WEB_API) Retrofit retrofit) {
        return retrofit.create(BaseWebApi.class);
    }
}
