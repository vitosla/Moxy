package com.vitos.moxy.events;

/**
 * Created by Victor on 28.05.2017.
 */

abstract class BaseSuccessfulEvent<T> {

    private final T data;

    BaseSuccessfulEvent(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}