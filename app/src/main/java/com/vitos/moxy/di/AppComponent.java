package com.vitos.moxy.di;

import android.content.Context;

import com.vitos.moxy.api.Api;
import com.vitos.moxy.api.retrofit.RetrofitService;
import com.vitos.moxy.di.Modules.ApiModule;
import com.vitos.moxy.di.Modules.ContextModule;
import com.vitos.moxy.di.Modules.RetrofitModule;
import com.vitos.moxy.mvp.presenters.MoxyPresenter;
import com.vitos.moxy.mvp.presenters.UserListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Victor on 28.05.2017.
 */

@Singleton
@Component (modules = {ContextModule.class, RetrofitModule.class, ApiModule.class})
public interface AppComponent {

    Context getContext();
    RetrofitService getRetrofitService();
    Api getApi();

    void inject (MoxyPresenter moxyPresenter);
    void inject (UserListPresenter userListPresenter);
}
