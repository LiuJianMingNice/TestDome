package com.example.kotlinprojection.wanandroid.utils

import android.content.Context

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * UserHelper
 * @author liujianming
 * @date 2021-12-06
 */
class UserHelper {

    companion object {
        private var instance: UserHelper? = null

        fun getInstance(): UserHelper? {
            if (instance == null) {
                synchronized(UserHelper::class) {
                    if (instance == null) {
                        instance = UserHelper()
                    }
                }
            }
            return instance
        }
    }

    fun isLogin(context: Context): Boolean {
        return PreferenceHelper.getBoolean(context, "isLogin")
    }

    fun loginOut(context: Context) {
        PreferenceHelper.putBoolean(context, "isLogin", false)
        val cookies = HashSet<String>()
        cookies.clear()
        PreferenceHelper.putStringSet(context, "cookie", cookies)
    }
}