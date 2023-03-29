package com.example.kotlinprojection.wanandroid.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * NoScrollViewpager
 * @author liujianming
 * @date 2021-12-06
 */
class NoScrollViewpager(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private var noScroll = false

    fun setNoScroll(noScroll: Boolean) {
        this.noScroll = noScroll
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return !noScroll&&super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return !noScroll&&super.onTouchEvent(ev)
    }

}