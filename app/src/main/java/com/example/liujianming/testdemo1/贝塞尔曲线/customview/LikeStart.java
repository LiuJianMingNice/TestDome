package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Interpolator;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.liujianming.testdemo1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LikeStart extends ViewGroup {
    private List<Drawable> mStartDrawable;
    private List<BaseInterpolator> mInterpolators;
    private int mWidth;
    private int mHeight;
    private Random random = new Random();
    private PointF mStartPoint, mEndPoint, mControlPointOne, mControlPointTwo;
    public LikeStart(Context context) {
        this(context,null);
//        init(context);
    }

    public LikeStart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//        init(context);
    }

    public LikeStart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        mStartDrawable = new ArrayList<>();
        mInterpolators = new ArrayList<>();
        mStartPoint = new PointF();
        mEndPoint = new PointF();
        mControlPointOne = new PointF();
        mControlPointTwo = new PointF();

        mStartDrawable.add(getResources().getDrawable(R.mipmap.heart_red));
        mStartDrawable.add(getResources().getDrawable(R.mipmap.heart_blue));
        mStartDrawable.add(getResources().getDrawable(R.mipmap.heart_yellow));
        mStartDrawable.add(getResources().getDrawable(R.mipmap.heart_green));

        mInterpolators.add(new LinearInterpolator());
        mInterpolators.add(new AccelerateDecelerateInterpolator());
        mInterpolators.add(new AccelerateInterpolator());
        mInterpolators.add(new DecelerateInterpolator());

        ImageView image_heard = new ImageView(context);
        image_heard.setImageDrawable(mStartDrawable.get(0));
        image_heard.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        image_heard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ljm","image_heard=onClick==>>> ");
                final ImageView image_random = new ImageView(context);
                image_random.setImageDrawable(mStartDrawable.get(random.nextInt(4)));
                image_random.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                addView(image_random);
                invalidate();

                PointF endPointRandom = new PointF(random.nextInt(mWidth), mEndPoint.y);
                BezierTypeEvaluator bezierTypeEvaluator = new BezierTypeEvaluator(new PointF( random.nextInt(mWidth ),random.nextInt(mHeight)), new PointF( random.nextInt(mWidth),random.nextInt(mHeight)));
                //开始做动画效果
//                BezierTypeEvaluator bezierTypeEvaluator = new BezierTypeEvaluator(mControlPointOne, mControlPointTwo);

                ValueAnimator valueAnimator = ValueAnimator.ofObject(bezierTypeEvaluator, mStartPoint, endPointRandom);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF pointF = (PointF) animation.getAnimatedValue();
                        image_random.setX(pointF.x);
                        image_random.setY(pointF.y);
                    }
                });
                valueAnimator.setDuration(2000);
                valueAnimator.start();
            }
        });
        addView(image_heard);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        //借用子View控件中的宽高
        View child = getChildAt(0);
        int childW = child.getMeasuredWidth();
        int childH = child.getMeasuredHeight();

        mStartPoint.x = (mWidth - childW) / 2;
        mStartPoint.y = mHeight - childH;
        mEndPoint.x = (mWidth - childW) / 2;
        mEndPoint.y = 0 - childH;

        mControlPointOne.x = random.nextInt(mWidth / 2);
        mControlPointOne.y = random.nextInt(mHeight / 2) + mHeight / 2;

        mControlPointTwo.x = random.nextInt(mWidth / 2) + mWidth / 2;
        mControlPointTwo.y = random.nextInt(mHeight / 2);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //保存测量高度
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d("ljm","l: " + l + ",t: " + t + ",r: " + r + ",b: " + b);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int childW = child.getMeasuredWidth();
            int childH = child.getMeasuredHeight();
            child.layout((mWidth - childW) / 2, (mHeight - childH), (mWidth - childW) / 2 + childW, mHeight);
        }
    }

    public void startRunning() {
        BezierTypeEvaluator bezierTypeEvaluator = new BezierTypeEvaluator(mControlPointOne, mControlPointTwo);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(bezierTypeEvaluator, mStartPoint, mEndPoint);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF) animation.getAnimatedValue();
                getChildAt(0).setX(pointF.x);
                getChildAt(0).setY(pointF.y);
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }

    public class BezierTypeEvaluator implements TypeEvaluator<PointF> {

        private PointF mControlPoint1, mControlPoint2;

        public BezierTypeEvaluator(PointF mControlPoint1, PointF mControlPoint2) {
            this.mControlPoint1 = mControlPoint1;
            this.mControlPoint2 = mControlPoint2;
        }

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            PointF pointCur = new PointF();
//            pointCur.x = mStartPoint.x + fraction * (endValue.x - mStartPoint.x);
//            pointCur.y = mStartPoint.y + fraction * (endValue.y - mStartPoint.y);
            //
            pointCur.x = mStartPoint.x * (1 - fraction) * (1 - fraction) * (1 - fraction)
                    + 3 * mControlPoint1.x * fraction * (1 - fraction) * (1 - fraction)
                    + 3 * mControlPoint2.x * fraction * fraction * (1 - fraction)
                    + endValue.x * fraction * fraction * fraction;
            pointCur.y = mStartPoint.y * (1 - fraction) * (1 - fraction) * (1 - fraction)
                    + 3 * mControlPoint1.y * fraction * (1 - fraction) * (1 - fraction)
                    + 3 * mControlPoint2.y * fraction * fraction * (1 - fraction)
                    + endValue.y * fraction * fraction * fraction;
            return pointCur;
        }
    }
}
