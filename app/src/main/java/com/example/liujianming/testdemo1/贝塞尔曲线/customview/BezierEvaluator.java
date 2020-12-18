package com.example.liujianming.testdemo1.贝塞尔曲线.customview;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

public class BezierEvaluator implements TypeEvaluator<PointF> {

    private PointF pointF1, pointF2;

    public BezierEvaluator(PointF pointF1, PointF pointF2) {
        this.pointF1 = pointF1;
        this.pointF2 = pointF2;
    }

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {

        float fractionLeft = 1.0f - fraction;
        PointF point = new PointF();
        point.x = fractionLeft * fractionLeft * fractionLeft * (startValue.x)
                + 3 * fractionLeft * fractionLeft * fraction * (pointF1.x)
                + 3 * fractionLeft * fraction * fraction * (pointF2.x)
                + fraction * fraction * fraction * (endValue.x);

        point.y = fractionLeft * fractionLeft * fractionLeft * (startValue.y)
                + 3 * fractionLeft * fractionLeft * fraction * (pointF1.y)
                + 3 * fractionLeft * fractionLeft * fraction * (pointF2.y)
                + fraction * fraction * fraction * (endValue.y);
        return point;
    }
}
