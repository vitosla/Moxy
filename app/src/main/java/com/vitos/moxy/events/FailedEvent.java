package com.vitos.moxy.events;

/**
 * Created by Victor on 28.05.2017.
 */

public class FailedEvent {

    private final String message;

    public FailedEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
