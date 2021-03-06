package com.vitos.moxy.mvp.models.repo;

import android.graphics.Bitmap;

import com.vitos.moxy.mvp.models.User;

import java.util.List;

import rx.Observable;

/**
 * Created by Victor on 28.05.2017.
 */

public interface IUserRepository {

    Observable<Void> updateUser(User user);

    Observable<User> getUser(String id);

    Observable<List<User>> getAllUsers();

    Observable<Void> postImage(String id, Bitmap bitmap);
}
