package com.example.kotlinprojection.wanandroid

import android.app.Application
import okhttp3.internal.Internal.instance

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * App
 * @author liujianming
 * @date 2021-12-03
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: App? = null
        fun getInstance(): App? {
            return instance
        }
    }
}