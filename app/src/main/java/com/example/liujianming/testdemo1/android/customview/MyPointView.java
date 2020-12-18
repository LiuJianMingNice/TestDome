package com.example.liujianming.testdemo1.android.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPointView extends View {

    private Point mPoint = new Point(100);

    public MyPointView(Context context) {
        super(context);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300, 300, mPoint.getRadius(), paint);
        }
        super.onDraw(canvas);
    }

    public int getPointRadius() {
        return 50;
    }

    public void setPointRadius(int radius) {
        mPoint.setRadius(radius);
        invalidate();
    }
}
