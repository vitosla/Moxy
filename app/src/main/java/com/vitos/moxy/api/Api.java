package com.vitos.moxy.api;

import android.graphics.Bitmap;

import com.vitos.moxy.api.repo.IRepositoryFactory;
import com.vitos.moxy.events.SuccessfulUserUpdateEvent;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.models.repo.IUserRepository;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Victor on 28.05.2017.
 */

public class Api {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    private IRepositoryFactory mRepositoryFactory;


    public void setRepositoryFactory(IRepositoryFactory repositoryFactory) {
        this.mRepositoryFactory = repositoryFactory;
    }

    public void updateUser(final User user) {
        IUserRepository repository = mRepositoryFactory.getUserRepository();
        mCompositeSubscription
                .add(repository.updateUser(user)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new BaseResultSubscriber<Void>() {
                            @Override
                            public void onSuccessful(Void data) {
                                EventBus.getDefault().post(new SuccessfulUserUpdateEvent(user));
                            }
                        }));
    }

    public Observable<User> getUser(String id){
        final IUserRepository repository = mRepositoryFactory.getUserRepository();
        return repository.getUser(id);
        //     return Observable.defer(() -> repository.getUser(id));
    }

    public Observable<List<User>> getAllUsers(){
        final IUserRepository repository = mRepositoryFactory.getUserRepository();
        return repository.getAllUsers();
        //     return Observable.defer(() -> repository.getUser(id));
    }

    public void postImage(String id, Bitmap bitmap) {
        IUserRepository repository = mRepositoryFactory.getUserRepository();
        mCompositeSubscription
                .add(repository.postImage(id, bitmap)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(aVoid -> {
                            //TODO
                        }));
    }

    public void cancelAll() {
        mCompositeSubscription.unsubscribe();
        mCompositeSubscription = new CompositeSubscription();
    }

}
