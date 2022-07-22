package com.example.pdfhelper.rspdfview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPdfRecyclerView
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPdfRecyclerView extends RecyclerView {
    public RSPdfRecyclerView(@NonNull Context context) {
        super(context);
    }

    public RSPdfRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RSPdfRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return false;
    }
}
