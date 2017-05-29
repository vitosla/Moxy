package com.vitos.moxy.mvp.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.api.Api;
import com.vitos.moxy.api.repo.RepositoryFactory;
import com.vitos.moxy.api.retrofit.RetrofitService;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.models.repo.RemoteUserRepository;
import com.vitos.moxy.mvp.views.IUserListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Victor on 28.05.2017.
 */

@InjectViewState
public class UserListPresenter extends BasePresenter<IUserListView>{

    public static final String TAG = "UserListPresenter";

    @Inject
    Api mApi;

    @Inject
    RetrofitService mRetrofitService;

    public UserListPresenter() {
        MoxyApp.getAppComponent().inject(this);
    }

    public void loadUsersData(){
        mApi.setRepositoryFactory(new RepositoryFactory());
        Subscription subscription = mApi.getAllUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        int uu=0;
                        uu++;
                    }

                    @Override
                    public void onNext(List<User> users) {
                        getViewState().onLoadUsersData(users);
                    }
                });
        unsubscribeOnDestroy(subscription);
    }
}
