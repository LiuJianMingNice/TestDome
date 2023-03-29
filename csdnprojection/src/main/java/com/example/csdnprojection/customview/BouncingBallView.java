package com.example.csdnprojection.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class BouncingBallView extends View {

    //小球球心横坐标
    private float ballCenterX = 50;

    //小球球心纵坐标
    private float ballCenterY = 50;

    //小球半径
    private float radius = 20;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint paint = new Paint();

        // 绘制红色小球
        paint.setColor(Color.RED);
        canvas.drawCircle(ballCenterX, ballCenterY, radius, paint);
    }

    public float getBallCenterX() {
        return ballCenterX;
    }

    public void setBallCenterX(float ballCenterX) {
        this.ballCenterX = ballCenterX;
    }

    public float getBallCenterY() {
        return ballCenterY;
    }

    public void setBallCenterY(float ballCenterY) {
        this.ballCenterY = ballCenterY;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }



    public BouncingBallView(Context context) {
        super(context);
    }

    public BouncingBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BouncingBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
