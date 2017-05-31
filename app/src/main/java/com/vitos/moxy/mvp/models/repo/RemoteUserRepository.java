package com.vitos.moxy.mvp.models.repo;

import android.content.Context;
import android.graphics.Bitmap;

import com.vitos.moxy.MoxyApp;
import com.vitos.moxy.api.retrofit.RetrofitService;
import com.vitos.moxy.mvp.models.User;
import com.vitos.moxy.mvp.models.UserDTO;
import com.vitos.moxy.mvp.models.UserMapper;
import com.vitos.moxy.tools.ImageUtils;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by Victor on 28.05.2017.
 */

public class RemoteUserRepository implements IUserRepository{

    @Inject
    RetrofitService mRetrofitService;
    @Inject
    Context mAppContext;

    public RemoteUserRepository() {
        MoxyApp.getAppComponent().inject(this);
    }

    @Override
    public Observable<Void> updateUser(User user) {
        UserDTO value = new UserMapper().map(user);
        return mRetrofitService.updateUser(value);
    }

    @Override
    public Observable<User> getUser(String id) {
        return mRetrofitService
                .getUser(id)
                .map(userDTO -> new UserMapper().map(userDTO));
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mRetrofitService
                .getAllUsers()
                .map(userDTO -> new UserMapper().call(userDTO));
    }

    @Override
    public Observable<Void> postImage(String id, Bitmap bitmap) {
        File file = ImageUtils.bitmapToFile(mAppContext, bitmap);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData(
                "file", file.getName(),
                RequestBody.create(MediaType.parse("image/*"), file));

        return mRetrofitService.postImage(id, filePart);
    }
}
