package com.vitos.moxy.events;

import com.vitos.moxy.mvp.models.User;

/**
 * Created by Victor on 28.05.2017.
 */

public class SuccessfulUserUpdateEvent extends BaseSuccessfulEvent<User> {

    public SuccessfulUserUpdateEvent(User data) {
        super(data);
    }
}
