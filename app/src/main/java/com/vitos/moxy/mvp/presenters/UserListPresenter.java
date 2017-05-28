package com.vitos.moxy.mvp.presenters;

import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.api.Api;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.views.IUserListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Victor on 28.05.2017.
 */

public class UserListPresenter extends BasePresenter<IUserListView>{

    public static final String TAG = "UserListPresenter";

    @Inject
    Api mApi;

    public UserListPresenter() {
        MoxyApp.getAppComponent().inject(this);
    }

    public void loadUsersData(){
        Subscription subscription = mApi.getAllUsers()
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        getViewState().onLoadUsersData(users);
                    }
                });
        unsubscribeOnDestroy(subscription);
    }
}
