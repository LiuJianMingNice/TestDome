package com.example.liujianming.testdemo1.android.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

import com.example.liujianming.testdemo1.R;

@SuppressLint("AppCompatCustomView")
public class PassWordEditText extends EditText {

    private int textLength;

    private int borderColor;
    private float borderWidth;
    private float borderRadius;

    private int passwordLength;
    private int passwordColor;
    private float passwordWidth;
    private float passwordRadius;

    private Paint passwordPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private final int defaultSplitLineWidth = 1;
    private int isClear = 0;

    public PassWordEditText(Context context) {
        super(context);
    }

    public PassWordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        final Resources res = getResources();

        final int defaultBorderColor = res.getColor(R.color.textColor);
        final float defaultBorderWidth = res.getDimension(R.dimen.dp_4);
        final float defaultBorderRadius = res.getDimension(R.dimen.dp_4);

        final int defaultPasswordLength = 4;
        final int defaultPasswordColor = res.getColor(R.color.textColor);
        final float defaultPasswordWidth = res.getDimension(R.dimen.dp_8);
        final float defaultPasswordRadius = res.getDimension(R.dimen.dp_4);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PassWordEditText, 0, 0);

        try {
            borderColor = a.getColor(R.styleable.PassWordEditText_borderColor, defaultBorderColor);
            borderWidth = a.getDimension(R.styleable.PassWordEditText_borderWidth, defaultBorderWidth);
            borderRadius = a.getDimension(R.styleable.PassWordEditText_borderRadius, defaultBorderRadius);
            passwordLength = a.getInt(R.styleable.PassWordEditText_passwordLength, defaultPasswordLength);
            passwordColor = a.getColor(R.styleable.PassWordEditText_passwordColor, defaultPasswordColor);
            passwordWidth = a.getDimension(R.styleable.PassWordEditText_passwordWidth, defaultPasswordWidth);
            passwordRadius = a.getDimension(R.styleable.PassWordEditText_passwordRadius, defaultPasswordRadius);
        } finally {
            a.recycle();
        }

        borderPaint.setStrokeWidth(borderWidth);
        borderPaint.setColor(borderColor);
        borderPaint.setStyle(Paint.Style.FILL);
        passwordPaint.setStrokeWidth(passwordWidth);
        passwordPaint.setColor(passwordColor);
        passwordPaint.setStyle(Paint.Style.FILL);
        setSingleLine(true);
    }

    public PassWordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();

        //分割线
        borderPaint.setColor(borderColor);
        borderPaint.setStrokeWidth(defaultSplitLineWidth);
        for (int i = 0; i < passwordLength; i++) {
            float x = width * i / passwordLength;
            float w = width * (i+1) / passwordLength;
            canvas.drawRect(x + 16, height - 5, w, height, borderPaint);
        }

        //密码
        float cx, cy = height / 2;
        float half = width / passwordLength / 2;
        for (int i = 0; i < textLength; i++) {
            cx = width * i / passwordLength + half + 8;
            canvas.drawCircle(cx, cy, passwordWidth, passwordPaint);
        }
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        borderPaint.setColor(borderColor);
//		invalidate();
    }

    public float getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(float borderWidth) {
        this.borderWidth = borderWidth;
        borderPaint.setStrokeWidth(borderWidth);
//		invalidate();
    }

    public float getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(float borderRadius) {
        this.borderRadius = borderRadius;
//		invalidate();
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
//		invalidate();
    }

    public int getPasswordColor() {
        return passwordColor;
    }

    public void setPasswordColor(int passwordColor) {
        this.passwordColor = passwordColor;
        passwordPaint.setColor(passwordColor);
//		invalidate();
    }

    public float getPasswordWidth() {
        return passwordWidth;
    }

    public void setPasswordWidth(float passwordWidth) {
        this.passwordWidth = passwordWidth;
        passwordPaint.setStrokeWidth(passwordWidth);
//		invalidate();
    }

    public float getPasswordRadius() {
        return passwordRadius;
    }

    public void setPasswordRadius(float passwordRadius) {
        this.passwordRadius = passwordRadius;
//		invalidate();
    }

    public int isClear(int isClear) {
        return this.textLength = isClear;
    }
}
