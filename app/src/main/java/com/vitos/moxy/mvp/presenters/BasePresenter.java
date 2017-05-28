package com.vitos.moxy.mvp.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Victor on 28.05.2017.
 */

public class BasePresenter <View extends MvpView> extends MvpPresenter<View> {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    protected void unsubscribeOnDestroy(@NonNull Subscription subscription) {
        mCompositeSubscription.add(subscription);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.clear();
    }
}
