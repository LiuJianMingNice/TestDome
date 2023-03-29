package com.example.kotlinprojection.kotlinTest.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * DrawView
 * @author liujianming
 * @date 2021-11-25
 */
class DrawView : View {
    private var currentX = 40f
    private var currentY = 50f
    //定义并创建画笔
    private var p = Paint()
    constructor(context: Context) : super(context)
    constructor(context: Context, set: AttributeSet) : super(context, set)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //设置画笔的颜色
        p.color = Color.RED
        //绘制一个小圆（作为小球）
        canvas.drawCircle(currentX, currentY, 15F, p)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //修改currentX、currentY两个属性
        currentX = event.x
        currentY = event.y
        invalidate()
        return true
    }
}