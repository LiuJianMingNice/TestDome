package com.example.kotlinprojection.kotlinTest.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * MyView
 * @author liujianming
 * @date 2021-11-29
 */
class MyView(context: Context, set: AttributeSet) : View(context, set) {
    private val path1 = Path()
    private val path2 = Path()
    private val path3 = Path()
    private val path4 = Path()
    private val path5 = Path()
    private val path6 = Path()

    private val mShader = LinearGradient(0f, 0f, 40f, 60f,
        intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW), null, Shader.TileMode.REPEAT)
    private val rect = RectF()
    //定义画笔
    private val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //把整张画布绘制成白色
        canvas?.drawColor(Color.WHITE)
        //去锯齿
        paint.isAntiAlias = true
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 4f
        val viewWidth = this.width.toFloat()
        //绘制圆形
        canvas?.drawCircle(viewWidth / 10 + 10, viewWidth / 10 + 10, viewWidth / 10, paint)

    }
}