package com.vitos.moxy.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vitos.moxy.BuildConfig;
import com.vitos.moxy.mvp.models.UserDTO;
import com.vitos.moxy.tools.DateHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Victor on 28.05.2017.
 */

public class RetrofitService implements IRetrofitService {

    private final OkHttpClient mClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
            .build();

    private final Gson mGson = new GsonBuilder()
            .setDateFormat(DateHelper.DATE_PATTERN_yyyy_MM_ddTHH_mm_ss)
            .create();

    private final IRetrofitService mCaller = new Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create(mGson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(mClient)
            .build()
            .create(IRetrofitService.class);

    @Override
    public Observable<Void> updateUser(UserDTO value) {
        return mCaller.updateUser(value);
    }

    @Override
    public Observable<UserDTO> getUser(String id) {
        return mCaller.getUser(id);
    }

    @Override
    public Observable<List<UserDTO>> getAllUsers() {
        return mCaller.getAllUsers();
    }

    @Override
    public Observable<Void> postImage(String id, MultipartBody.Part filePart) {
        return mCaller.postImage(id, filePart);
    }
}
