package com.example.liujianming.testdemo1.简书Demo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingBoardView extends View {

    private Paint paint;
    //笔颜色
    private int drawColor = Color.BLACK;
    //笔粗细
    private int drawWidth = 5;
    private Path path;
    //每次触碰画板时的横坐标
    private float downX;
    //每次触碰画板时的纵坐标
    private float downY;
    //最小画线距离，值越小，灵敏度越高
    private float minInvalidateLength = 2;
    public DrawingBoardView(Context context) {
        super(context);
        init();
    }

    public DrawingBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(drawColor);
        paint.setStrokeWidth(drawWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        path = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                path.moveTo(downX, downY);
                break;
            case MotionEvent.ACTION_MOVE:
                //每移动超过一定单位距离，就判定需要在此路径上画曲线
                float difX = event.getX() - downX;
                float difY = event.getY() - downY;
                if (Math.abs(difX) > minInvalidateLength || Math.abs(difY) > minInvalidateLength) {
                    //画出该段距离的曲线，并将dif重置为0,重新机选差值
                    path.quadTo((downX+event.getX()) / 2, (downY + event.getY()) / 2, event.getX(), event.getY());
                    downX = event.getX();
                    downY = event.getY();
                }
                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    //清空画布
    public void clearPanel() {
        path.reset();
        invalidate();
    }

    //设置画笔颜色
    public void setPaintColor(int color) {
        this.drawColor = color;
        paint.setColor(color);
        invalidate();
    }

    //设置画笔粗细
    public void setDrawWidth(int drawWidth) {
        this.drawWidth = drawWidth;
        paint.setStrokeWidth(drawWidth);
    }

    /**
     * 从View获取bitmap
     * setDrawingCacheEnabled(true) 设置能否缓存图片信息
     * buildDrawingCache() 如果能够缓存图片，则创建图片缓存
     * getDrawingCache() 如果图片已经缓存，返回一个bitmap
     * destroyDrawingCache() 释放缓存占用的资源
     */
    public Bitmap getPanelBitmap() {
        return getDrawingCache();
    }
}
