package com.vitos.moxy.mvp.presenters;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.di.AppComponent;
import com.vitos.moxy.mvp.views.IMainView;

import javax.inject.Inject;

/**
 * Created by Victor on 28.05.2017.
 */

@InjectViewState
public class MoxyPresenter extends MvpPresenter<IMainView>{

    @Inject
    Context mContext;

    public MoxyPresenter() {
        MoxyApp.getAppComponent().inject(this);
    }

    public void showItemDetails(String id) {
        //TODO
    }
}
