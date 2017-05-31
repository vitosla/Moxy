package com.vitos.moxy.api;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.vitos.moxy.R;
import com.vitos.moxy.events.FailedEvent;
import com.vitos.moxy.tools.AppLog;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Victor on 28.05.2017.
 */

public abstract class BaseResultSubscriber<T> extends Subscriber<T> {

    @Inject Context mAppContext;

    @Override
    public void onCompleted() { }


    @Override
    public void onError(Throwable e) {

        String message = e.getMessage();
        AppLog.e(message);

        if (e instanceof ConnectException) {
            message = mAppContext.getString(R.string.connect_exception_error);
        }
        else if (e instanceof SocketTimeoutException){
            message = mAppContext.getString(R.string.timeout_error);
        }
        else if (e instanceof UnknownHostException || e instanceof NetworkErrorException) {
            message = mAppContext.getString(R.string.network_error);
        }
        else {
            message = mAppContext.getString(R.string.something_went_wrong);
        }

        EventBus.getDefault().post(new FailedEvent(message));
    }


    @Override
    public void onNext(T data) {
        onSuccessful(data);
    }


    public abstract void onSuccessful(T data);
}
