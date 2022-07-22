package com.example.pdfhelper.rspdfview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.pdfhelper.R;
import com.example.pdfhelper.pdfview.utils.PdfLog;
import com.example.pdfhelper.pdfview.widget.PdfLoadingLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPdfLoadingLayout
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPdfLoadingLayout extends FrameLayout {

    TextView waitTv;
    Button reloadBtn;
    View waitLayout;
    LoadLayoutListener mListener;


    public RSPdfLoadingLayout(@NonNull Context context) {
        this(context, null);
    }

    public RSPdfLoadingLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RSPdfLoadingLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.rs_layout_pdf_loading, this);

        waitTv = findViewById(R.id.waiting_tv);
        reloadBtn = findViewById(R.id.reload_tv);
        waitLayout = findViewById(R.id.waiting_layout);

        reloadBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.clickRetry();
                }
            }
        });
    }

    public void showLoading() {
        PdfLog.logDebug("showLoading");
        setVisibility(VISIBLE);
        waitTv.setText("加载中");
        reloadBtn.setVisibility(GONE);
    }

    public void showContent() {
        PdfLog.logDebug("showContent");
        setVisibility(GONE);
    }

    public void showFail() {
        setVisibility(VISIBLE);
        waitTv.setText("加载失败");
        waitLayout.setVisibility(GONE);
        reloadBtn.setVisibility(VISIBLE);
    }

    public void setLoadLayoutListener(LoadLayoutListener listener) {
        mListener = listener;
    }

    public interface LoadLayoutListener {
        void clickRetry();
    }
}
