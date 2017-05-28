package com.vitos.moxy.di.Modules;

import com.vitos.moxy.api.retrofit.RetrofitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Victor on 28.05.2017.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    RetrofitService provideRetrofitService(){
        return new RetrofitService();
    }
}
