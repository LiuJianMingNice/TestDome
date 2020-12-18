package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawQuadToView extends View {

    private int leftX, leftY;
    private int rightX, rightY;
    private int eventX, eventY;
    private int centerX, centerY;
    private int startX, startY;
    private int endX, endY;
    private Paint mPaint;
    private boolean isMoveLeft;

    public DrawQuadToView(Context context) {
        super(context);
        init();
    }

    public DrawQuadToView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    //二阶贝塞尔曲线
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        centerX = w / 2;
//        centerY = h / 2;
//        startX = centerX - 250;
//        startY = centerY;
//        endX = centerX + 250;
//        endY = centerY;
//        eventX = centerX;
//        eventY = centerY - 250;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawCircle(startX,startY,8,mPaint);
//        canvas.drawCircle(endX,endY,16,mPaint);
//        canvas.drawCircle(eventX,eventY,24,mPaint);
//        mPaint.setStrokeWidth(3);
//        canvas.drawLine(startX, centerY, eventX, eventY, mPaint);
//        canvas.drawLine(endX, centerY, eventX, eventY, mPaint);
//        mPaint.setColor(Color.GREEN);
//        mPaint.setStyle(Paint.Style.STROKE);
//        Path path = new Path();
//        path.moveTo(startX, startY);
//        path.quadTo(eventX, eventY, endX, endY);
//        canvas.drawPath(path, mPaint);
//    }

    //三阶贝塞尔曲线
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        centerX = w/2;
        centerY = w/2;
        startX = centerX - 250;
        startY = centerY;
        endX = centerX + 250;
        endY = centerY;
        leftX = startX;
        leftY = centerY - 250;
        rightX = endX;
        rightY = endY - 250;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.drawCircle(startX, startY, 8, mPaint);
        canvas.drawCircle(endX, endY, 8, mPaint);
        canvas.drawCircle(leftX, leftY, 8, mPaint);
        canvas.drawCircle(rightX, rightY, 8, mPaint);

        canvas.drawLine(startX, startY, leftX, leftY, mPaint);
        canvas.drawLine(leftX, leftY, rightX, rightY, mPaint);
        canvas.drawLine(rightX, rightY, endX, endY, mPaint);

        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(startX, startY);
        path.cubicTo(leftX, leftY, rightX, rightY, endX, endY);
        canvas.drawPath(path, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                if (isMoveLeft) {
                    leftX = (int) event.getX();
                    leftY = (int) event.getY();;
                } else {
                    rightX = (int) event.getX();
                    rightY = (int) event.getY();
                }
                invalidate();
                break;
        }
        return true;
    }

    public void moveLeft() {
        isMoveLeft = true;
    }

    public void moveRight() {
        isMoveLeft = false;
    }
}
