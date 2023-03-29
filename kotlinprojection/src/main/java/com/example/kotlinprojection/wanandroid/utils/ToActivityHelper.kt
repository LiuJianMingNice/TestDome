package com.example.kotlinprojection.wanandroid.utils

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ToActivityHelper
 * @author liujianming
 * @date 2021-12-06
 */
class ToActivityHelper {

    companion object {
        private var instance: ToActivityHelper? = null
        fun getInstance(): ToActivityHelper? {
            if (instance == null) {
                synchronized(ToActivityHelper::class) {
                    if (instance == null)
                        instance = ToActivityHelper()
                }
            }
            return instance
        }
    }

    fun toActivity(_activity: Activity, _class: Class<out Activity>) {
        _activity.startActivity(Intent(_activity, _class))
    }

    fun toActivity(_activity: Activity, _class: Class<out Activity>,bundle: Bundle){
        _activity.startActivity(Intent(_activity, _class).putExtras(bundle))
    }

    fun toActivityFinish(_activity: Activity, _class: Class<out Activity>){
        _activity.startActivity(Intent(_activity, _class))
        _activity.finish()
    }

    fun toActivityFinish(_activity: Activity, _class: Class<out Activity>,bundle: Bundle){
        _activity.startActivity(Intent(_activity, _class).putExtras(bundle))
        _activity.finish()
    }
}