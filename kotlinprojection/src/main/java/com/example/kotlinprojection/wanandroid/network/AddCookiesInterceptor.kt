package com.example.kotlinprojection.wanandroid.network

import android.util.Log
import com.example.kotlinprojection.wanandroid.App
import com.example.kotlinprojection.wanandroid.utils.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * AddCookiesInterceptor
 * @author liujianming
 * @date 2021-12-06
 */
class AddCookiesInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain!!.request().newBuilder()
        val preferences = PreferenceHelper.getStringSet(App.getInstance()!!.applicationContext, "cookie")

        if (preferences != null) {
            for (cookie in preferences) {
                builder.addHeader("Cookie", cookie)
                Log.v("okhttp", "Adding Header: $cookie")
            }
        }
        return chain.proceed(builder.build())
    }
}