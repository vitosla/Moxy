package com.vitos.moxy.di;

import android.content.Context;

import com.vitos.moxy.api.retrofit.RetrofitService;
import com.vitos.moxy.di.Modules.ContextModule;
import com.vitos.moxy.di.Modules.RetrofitModule;
import com.vitos.moxy.mvp.presenters.MoxyPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Victor on 28.05.2017.
 */

@Singleton
@Component (modules = {ContextModule.class, RetrofitModule.class})
public interface AppComponent {

    Context getContext();
    RetrofitService getRetrofitService();

    void inject (MoxyPresenter moxyPresenter);
}
