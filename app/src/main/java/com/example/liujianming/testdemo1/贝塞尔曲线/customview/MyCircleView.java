package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class MyCircleView extends View {

    private int mCenterX;
    private int mCenterY;
    private Paint mPaint;

    private Paint mPaintCircle, mPaintPoint;
    private int mCircleRadius;
    private List<PointF> mPointDatas, mPointControlls;

    private int mDuration = 1000;
    private int mCurrTime;
    private int mCount = 100;
    private float mPiece = mDuration / mCount;
    private boolean isRunning;

    public MyCircleView(Context context) {
        super(context);
        init();
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.save();
        canvas.drawLine(mCenterX, 0, mCenterX, getHeight(), mPaint);
        canvas.drawLine(0, mCenterY, getWidth(), mCenterY, mPaint);

        for (int i = 0; i < mPointDatas.size(); i++) {
            canvas.drawPoint(mPointDatas.get(i).x, mPointDatas.get(i).y, mPaintPoint);
        }

        for (int i = 0; i < mPointControlls.size(); i++) {
            canvas.drawPoint(mPointControlls.get(i).x, mPointControlls.get(i).y, mPaintPoint);
        }

        Path path = new Path();
        path.moveTo(mPointDatas.get(0).x, mPointDatas.get(0).y);
        for (int i = 0; i < mPointDatas.size(); i++) {
            if (i == mPointDatas.size() - 1) {
                path.cubicTo(mPointControlls.get(2*i).x, mPointControlls.get(2*i).y, mPointControlls.get(2*i+1).x, mPointControlls.get(2*i+1).y, mPointDatas.get(0).x, mPointDatas.get(0).y);
            } else {
                path.cubicTo(mPointControlls.get(2*i).x, mPointControlls.get(2*i).y, mPointControlls.get(2*i+1).x, mPointControlls.get(2*i+1).y, mPointDatas.get(i + 1).x, mPointDatas.get(i + 1).y);
            }
        }
        path.cubicTo(mPointControlls.get(0).x, mPointControlls.get(0).y, mPointControlls.get(1).x, mPointControlls.get(1).y, mPointDatas.get(1).x, mPointDatas.get(1).y);
        canvas.drawPath(path, mPaintCircle);
//        canvas.restore();

        if (isRunning) {
            mCurrTime += mPiece;
            if (mCurrTime < mDuration) {
                mPointDatas.get(0).y += 120 / mCount;
                mPointControlls.get(2).x -= 20.0 / mCount;
                mPointControlls.get(3).y -= 80.0 / mCount;
                mPointControlls.get(4).y -= 80.0 / mCount;
                mPointControlls.get(5).x += 20.0 /mCount;
                postInvalidateDelayed((long) mPiece);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;

        mPointDatas = new ArrayList<>();
        mPointControlls = new ArrayList<>();

        mPointDatas.add(new PointF(mCenterX, mCenterY - mCircleRadius));
        mPointDatas.add(new PointF(mCenterX + mCircleRadius, mCenterY));
        mPointDatas.add(new PointF(mCenterX, mCenterY + mCircleRadius));
        mPointDatas.add(new PointF(mCenterX - mCircleRadius, mCenterY));

        mPointControlls.add(new PointF(mCenterX + mCircleRadius / 2, mCenterY - mCircleRadius));
        mPointControlls.add(new PointF(mCenterX + mCircleRadius, mCenterY - mCircleRadius / 2));

        mPointControlls.add(new PointF(mCenterX + mCircleRadius, mCenterY + mCircleRadius / 2));
        mPointControlls.add(new PointF(mCenterX + mCircleRadius / 2, mCenterY + mCircleRadius));

        mPointControlls.add(new PointF(mCenterX - mCircleRadius / 2, mCenterY + mCircleRadius));
        mPointControlls.add(new PointF(mCenterX - mCircleRadius, mCenterY + mCircleRadius / 2));

        mPointControlls.add(new PointF(mCenterX - mCircleRadius, mCenterY - mCircleRadius / 2));
        mPointControlls.add(new PointF(mCenterX - mCircleRadius / 2, mCenterY - mCircleRadius));
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);

        mPaintCircle = new Paint();
        mPaintCircle.setColor(Color.RED);
        mPaintCircle.setStrokeWidth(15);
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setAntiAlias(true);

        mPaintPoint = new Paint();
        mPaintPoint.setColor(Color.BLACK);
        mPaintPoint.setStrokeWidth(15);
        mPaintPoint.setStyle(Paint.Style.FILL);
        mPaintPoint.setAntiAlias(true);

        mCircleRadius = 150;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
        invalidate();
    }
}
