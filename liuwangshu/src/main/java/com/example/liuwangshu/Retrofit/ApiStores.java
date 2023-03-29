package com.example.liuwangshu.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * ApiStores
 *
 * @author liujianming
 * @date 2022-08-18
 */
public interface ApiStores {
    @GET("adat/sk/{cityId}.html")
    Call<ResponseBody> getWeather(@Path("cityId") String cityId);
}
