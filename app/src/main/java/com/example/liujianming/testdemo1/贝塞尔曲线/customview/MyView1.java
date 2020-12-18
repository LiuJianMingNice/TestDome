package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView1 extends View {

    private Paint mPaint;
    private boolean isControlPointTwo;
    private Point controlPoint1 = new Point(200, 200);
    private Point controlPoint2 = new Point(500, 500);

    public MyView1(Context context) {
        super(context);
        init();
    }

    public MyView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(100,500);
        path.cubicTo(controlPoint1.x, controlPoint1.y,controlPoint2.x, controlPoint2.y, 900,500);
        canvas.drawPath(path, mPaint);
        canvas.drawPoint(controlPoint1.x, controlPoint1.y, mPaint);
        canvas.drawPoint(controlPoint2.x, controlPoint2.y, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_DOWN:
                if (isControlPointTwo) {
                    controlPoint1.x = (int) event.getX();
                    controlPoint1.y = (int) event.getY();
                } else {
                    controlPoint2.x = (int) event.getX();
                    controlPoint2.y = (int) event.getY();
                }
                invalidate();
                break;
        }
        return true;
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    public boolean isControlPointTwo() {
        return isControlPointTwo;
    }

    public void setControlPointTwo(boolean isControlPointTwo) {
        this.isControlPointTwo = isControlPointTwo;
    }
}
