package com.example.liuwangshu.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * IpService
 *
 * @author liujianming
 * @date 2022-08-17
 */
public interface IpService {
    @GET("getIpInfo.php")
    Call<IpModel> getIpMsg(@Query("ip")String ip);
}
