package com.example.kotlinprojection.wanandroid.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.util.DisplayMetrics

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * Density
 * @author liujianming
 * @date 2021-12-03
 */
object Density {

    private var sNonCompatDensity: Float = 0.toFloat()
    private var sNonCompatScaledDensity: Float = 0.toFloat()

    private var oldDensity = -1f
    private var oldDensityDpi = -1
    private var oldScaledDensity = -1f

    fun setCustomDensity(activity: Activity, application: Application) {
        var appDisplayMetrics: DisplayMetrics = application.resources.displayMetrics

        if (sNonCompatDensity == 0.toFloat()) {
            sNonCompatDensity = appDisplayMetrics.density
            sNonCompatScaledDensity = appDisplayMetrics.scaledDensity

            application.registerComponentCallbacks(object : ComponentCallbacks{
                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.resources.displayMetrics.scaledDensity
                    }
                }

                override fun onLowMemory() {

                }

            })
            val targetDensity = appDisplayMetrics.widthPixels.toFloat() / 384
            val targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity)
            val targetDensityDpi = (160 * targetDensity).toInt()
            appDisplayMetrics.density = targetDensity
            appDisplayMetrics.scaledDensity = targetScaledDensity
            appDisplayMetrics.densityDpi = targetDensityDpi

            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = targetDensity
            activityDisplayMetrics.scaledDensity = targetScaledDensity
            activityDisplayMetrics.densityDpi = targetDensityDpi
        }
    }

    fun resetDensity(activity: Activity,application:Application ){
        var appDisplayMetrics:DisplayMetrics=application.resources.displayMetrics
        if(oldDensity==-1f){
            oldDensity=appDisplayMetrics.density
        }
        if(oldDensityDpi==-1){
            oldDensityDpi=appDisplayMetrics.densityDpi
        }
        if(oldScaledDensity==-1f){
            oldScaledDensity=appDisplayMetrics.scaledDensity
        }

        if(sNonCompatDensity==0.toFloat()){
            sNonCompatDensity=appDisplayMetrics.density
            sNonCompatScaledDensity=appDisplayMetrics.scaledDensity

            application.registerComponentCallbacks(object :ComponentCallbacks{

                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.resources.displayMetrics.scaledDensity
                        oldScaledDensity *= newConfig.fontScale
                    }
                }
            })


            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = oldDensity
            activityDisplayMetrics.scaledDensity = oldScaledDensity
            activityDisplayMetrics.densityDpi = oldDensityDpi
        }
    }
}