package com.example.pdfhelper.rspdfview.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pdfhelper.R;
import com.example.pdfhelper.pdfview.widget.AbsControllerBar;

import androidx.annotation.Nullable;

import static android.view.Gravity.CENTER;
import static android.widget.LinearLayout.HORIZONTAL;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPDFControllerBar
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPDFControllerBar extends RSAbsControllerBar implements View.OnClickListener {

    private Button previousBtn, nextBtn;
    private TextView pageIndexTv;

    public RSPDFControllerBar(Context context) {
        this(context, null);
    }

    public RSPDFControllerBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RSPDFControllerBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View getView() {
        LinearLayout rootView= new LinearLayout(getContext());
        rootView.setOrientation(HORIZONTAL);
        rootView.setGravity(CENTER);
        setBackgroundColor(Color.WHITE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(dip2px(getContext(), 8));
        }

        previousBtn = new Button(getContext());
        previousBtn.setBackgroundResource(R.drawable.bg_operate_btn);
        previousBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        previousBtn.setText("上一页");
        rootView.addView(previousBtn, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dip2px(getContext(), 36)));

        pageIndexTv = new TextView(getContext());
        pageIndexTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        pageIndexTv.setPadding(dip2px(getContext(), 16), 0, dip2px(getContext(), 16), 0);
        rootView.addView(pageIndexTv, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        pageIndexTv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pageIndexTv.setText("1/1");

        nextBtn = new Button(getContext());
        nextBtn.setBackgroundResource(R.drawable.bg_operate_btn);
        nextBtn.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        nextBtn.setText("下一页");
        rootView.addView(nextBtn, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dip2px(getContext(), 36)));

        previousBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view == previousBtn) {
            previousPage();
        } else if (view == nextBtn) {
            nextPage();
        }
    }

    @Override
    public void setPreviousText(String previousText) {
        Log.d("ljm", "previousText===>> " + previousText);
        if (previousBtn != null && previousText != null) {
            previousBtn.setText(previousText);
        }
    }

    @Override
    public void setNextText(String nextText) {
        Log.d("ljm", "nextText===>> " + nextText);
        if (nextBtn != null && nextText != null) {
            nextBtn.setText(nextText);
        }
    }

    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void setThePageNumber(String number) {
        if (pageIndexTv != null && number != null) {
            pageIndexTv.setText(number);
        }
    }
}
