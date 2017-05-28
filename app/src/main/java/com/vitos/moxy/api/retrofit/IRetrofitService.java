package com.vitos.moxy.api.retrofit;

import com.vitos.moxy.mvp.models.UserDTO;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Victor on 28.05.2017.
 */

public interface IRetrofitService {

    @POST("/api/users")
    Observable<Void> updateUser(
            @Body UserDTO value
    );

    @GET("/api/users/{id}")
    Observable<UserDTO> getUser(@Path("id") String id);

    @Multipart
    @POST("/api/users/{id}/image")
    Observable<Void> postImage(@Path("id") String id, @Part MultipartBody.Part filePart);
}
