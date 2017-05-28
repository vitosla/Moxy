package com.vitos.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.api.Api;
import com.vitos.moxy.api.retrofit.RetrofitService;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.models.UserDTO;
import com.vitos.moxy.mvp.views.IMainView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Victor on 28.05.2017.
 */

@InjectViewState
public class MoxyPresenter extends BasePresenter<IMainView>{

    public MoxyPresenter() {
        MoxyApp.getAppComponent().inject(this);
    }


}
