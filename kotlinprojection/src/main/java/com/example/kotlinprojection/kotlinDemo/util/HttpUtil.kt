package com.example.kotlinprojection.kotlinDemo.util

import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.*
import java.util.concurrent.Executors
import java.util.concurrent.FutureTask

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * HttpUtil
 * @author liujianming
 * @date 2021-12-02
 */
object HttpUtil {
    const val BASE_URL = ""
    val cookieStore = HashMap<String, List<Cookie>?>()
    //创建线程池
    private val threadPool = Executors.newFixedThreadPool(30)
    //创建默认的OkHttpClient对象
    private val okHttpClient = OkHttpClient.Builder()
            .cookieJar(object : CookieJar{
                override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
                    cookieStore[url.host()] = cookies
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore[url.host()]
                    return cookies ?: ArrayList()
                }
            }).build()

    fun getRequest(url: String): String? {
        val task = FutureTask<String> {
            val request = Request.Builder()
                    .url(url)
                    .build()
            val call = okHttpClient.newCall(request)
            //发送GET请求
            val response = call.execute()
            //如果服务器成功地返回响应
            if (response.isSuccessful) {
                //获取服务器响应字符串
                response.body()?.string()?.trim()
            } else {
                null
            }
        }
        threadPool.submit(task)
        return task.get()
    }

    fun postRequest(url: String, rawParams: Map<String, String>): String? {
        val task = FutureTask<String>({
            val builder = FormBody.Builder()
            rawParams.forEach({key, value -> builder.add(key, value)})
            val body = builder.build()
            val request = Request.Builder().url(url)
                    .post(body).build()
            val call = okHttpClient.newCall(request)
            val response = call.execute()
            if (response.isSuccessful) {
                response.body()?.string()?.trim()
            } else {
                null
            }
        })
        threadPool.submit(task)
        return task.get()
    }

}