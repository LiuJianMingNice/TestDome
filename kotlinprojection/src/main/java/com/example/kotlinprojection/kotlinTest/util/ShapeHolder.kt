package com.example.kotlinprojection.kotlinTest.util

import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.drawable.ShapeDrawable

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ShapeHolder
 * @author liujianming
 * @date 2021-11-29
 */
class ShapeHolder(var shape: ShapeDrawable) {
    internal var x = 0f
    var y = 0f
    internal var gradient: RadialGradient? = null
    var alpha = 1f
    lateinit var paint: Paint
}