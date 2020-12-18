package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.liujianming.testdemo1.R;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class MyGiftView extends RelativeLayout {


    private int screenWidth;
    private int screenHeight;
    private LayoutParams layoutParams;
    private Drawable[] drawables = new Drawable[5];

    public MyGiftView(Context context) {
        super(context);
        init();
    }

    public MyGiftView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        drawables[0]  = ContextCompat.getDrawable(getContext(), R.mipmap.ic1);
        drawables[1]  = ContextCompat.getDrawable(getContext(), R.mipmap.ic2);
        drawables[2]  = ContextCompat.getDrawable(getContext(), R.mipmap.ic3);
        drawables[3]  = ContextCompat.getDrawable(getContext(), R.mipmap.ic4);
        drawables[4]  = ContextCompat.getDrawable(getContext(), R.mipmap.ic5);

        layoutParams = new LayoutParams(100, 100);
        layoutParams.addRule(CENTER_HORIZONTAL, TRUE);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM, TRUE);
    }

    public void addImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(drawables[(int) (Math.random() * drawables.length)]);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
        setAnim(imageView).start();
        getBezierValueAnimator(imageView).start();
    }

    private ValueAnimator getBezierValueAnimator(View target) {
        BezierEvaluator evaluator = new BezierEvaluator(getPointF(), getPointF());

        PointF randomEndPoint = new PointF((float)(Math.random()*screenWidth), (float) (Math.random()*50));
        Log.d("ljm","randomEndPoint.x===>>> " + randomEndPoint.x + ",randEndPoint.y===>>> " + randomEndPoint.y);
        ValueAnimator animator = ValueAnimator.ofObject(evaluator, new PointF(screenWidth / 2, screenHeight), randomEndPoint);
        animator.addUpdateListener(new BezierListener(target));
        animator.setTarget(target);
        animator.setDuration(3000);
        return animator;
    }

    private PointF getPointF() {
        PointF pointF = new PointF();
        Log.d("ljm","screenWidth===>>> " + screenWidth + ",screenHeight===>>> " + screenHeight);
        pointF.x = (float) (Math.random() * screenWidth);
        pointF.y = (float) (Math.random() * screenHeight/4);
        return pointF;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        screenWidth = getMeasuredWidth();
        screenHeight = getMeasuredHeight();
    }

    private AnimatorSet setAnim(View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, 0.2f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.2f, 1f);

        AnimatorSet enter = new AnimatorSet();
        enter.setDuration(500);
        enter.setInterpolator(new LinearInterpolator());
        enter.playTogether(scaleX, scaleY);
        enter.setTarget(view);

        return enter;
    }

    private class BezierListener implements ValueAnimator.AnimatorUpdateListener {

        private View target;

        public BezierListener(View target) {
            this.target = target;
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            PointF pointF = (PointF) animation.getAnimatedValue();
            target.setX(pointF.x);
            target.setY(pointF.y);
            target.setAlpha(1 - animation.getAnimatedFraction());
        }
    }
}
