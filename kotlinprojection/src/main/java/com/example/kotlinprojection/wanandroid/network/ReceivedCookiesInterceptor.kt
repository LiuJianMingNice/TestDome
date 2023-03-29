package com.example.kotlinprojection.wanandroid.network

import com.example.kotlinprojection.wanandroid.App
import com.example.kotlinprojection.wanandroid.utils.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ReceivedCookiesInterceptor
 * @author liujianming
 * @date 2021-12-06
 */
class ReceivedCookiesInterceptor: Interceptor {
    /**
     * 首次请求cookie为空，需要从响应报文中获取，并保存到客户端的首选项中
     * 非首次请求时，从首选中取出cookie并添加到请求头中
     */
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalResponse = chain!!.proceed(chain!!.request())
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            val cookies = HashSet<String>()
            for(head in originalResponse.headers("Set-Cookie")) {
                cookies.add(head)
            }
            PreferenceHelper.putStringSet(App.getInstance()!!.applicationContext, "cookie", cookies)
        }
        return originalResponse
    }
}