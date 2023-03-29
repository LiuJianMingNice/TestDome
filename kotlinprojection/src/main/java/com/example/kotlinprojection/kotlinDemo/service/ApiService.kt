package com.example.kotlinprojection.kotlinDemo.service

import com.example.kotlinprojection.kotlinDemo.Entity.ResultBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ApiService
 * @author liujianming
 * @date 2021-12-16
 */
interface ApiService {
    //POST请求
    @FormUrlEncoded
    @POST("/1211-1")
    suspend fun post(@Field("showapi_appid") showapi_appid: String?,@Field("showapi_sign") showapi_sign: String?): ResultBean
}