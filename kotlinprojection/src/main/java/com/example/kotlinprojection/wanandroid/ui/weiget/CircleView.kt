package com.example.kotlinprojection.wanandroid.ui.weiget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * CircleView
 * @author liujianming
 * @date 2021-12-03
 */
class CircleView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private var paint: Paint = Paint()
    private var color: Int = 0

    constructor(context: Context) : this(context, null) {}

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.isDither = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var cx: Float = (width / 2).toFloat()
        canvas?.drawCircle(cx, cx, cx, paint)
    }

    fun changeColor(color: Int) {
        this.color = color
        paint.color = ContextCompat.getColor(context, color)
        invalidate()
    }

    fun getColor(): Int {
        return color
    }
}