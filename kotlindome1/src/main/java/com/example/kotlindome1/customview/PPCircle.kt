package com.example.kotlindome1.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * PPCircle
 * @author liujianming
 * @date 2022-06-23
 */
class PPCircle : View {

    var mDatas = ArrayList<Float>()
    var mColors = ArrayList<Int>(4)
    var mPaint: Paint = Paint()

//    init {
//        initPaint()
//    }

    constructor(mContext: Context) : super(mContext) {
        val context = mContext
    }
    constructor(mContext: Context, mAttributeSet: AttributeSet) : super(mContext, mAttributeSet) {
        initPaint()
        val context = mContext
    }

    fun initPaint() {
        Log.d("ljm", "initPaint===>>>")
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = 0xff44b391.toInt()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec)
        val mLayoutSize = widthSpecSize.coerceAtMost(heightSpecSize)
        setMeasuredDimension(mLayoutSize, mLayoutSize)
    }

    fun setData(data: ArrayList<Float>, colors: ArrayList<Int>) {
        Log.d("ljm", "setData===>>>")
        mDatas = data
        mColors = colors
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mDatas.size == 0) {
            return
        }

        //切掉圆心
        var mPath = Path()
        mPath.addCircle(width / 2f, height / 2f, width / 2f * 0.4f, Path.Direction.CW)
        mPath.close()
//        canvas?.clipPath(mPath, Region.Op.XOR)
        canvas?.clipPath(mPath)

        var total = 0f
        //此处亮点
        mDatas.forEach{
            total += it
        }
        var rf = RectF(0f, 0f, width.toFloat(), height.toFloat())
        var startAngle = -90f
        var i = 0
        mDatas.forEach {
            mPaint.color = mColors[i]
            var sweepAngle = it * 360 / total
            canvas?.drawArc(rf, startAngle, sweepAngle, true, mPaint)
            startAngle += sweepAngle
            i++
        }
    }

    override fun scrollTo(x: Int, y: Int) {
        super.scrollTo(x, y)

        invalidate()
    }

//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        return super.onTouchEvent(event)
//        event.rawX
//    }
}