package com.example.pdfhelper.rspdfview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.pdfhelper.rspdfview.interfaces.IPDFControl;
import com.example.pdfhelper.rspdfview.interfaces.IPDFOperateListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSAbsControllerBar
 *
 * @author liujianming
 * @date 2022-07-20
 */
public abstract class RSAbsControllerBar extends FrameLayout implements IPDFControl {

    protected List<IPDFOperateListener> mListeners;

    public RSAbsControllerBar(@NonNull Context context) {
        this(context, null);
    }

    public RSAbsControllerBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RSAbsControllerBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    protected abstract View getView();

    public void setPreviousText(String previousText) {

    }

    public void setNextText(String nextText) {

    }


    private void initView(Context context) {
        View view = getView();
        if (view == null) {
            return;
        }
        addView(view);
        mListeners = new ArrayList<>();
    }

    protected void previousPage() {
        Log.d("ljm", "previousPage====" + mListeners.size());
        for (IPDFOperateListener listener : mListeners) {
            if (listener != null) {
                listener.previousPage();
            }
        }
    }
    protected void nextPage() {
        for (IPDFOperateListener listener : mListeners) {
            if (listener != null) {
                listener.nextPage();
            }
        }
    }

    @Override
    public void addPDFOperateListener(IPDFOperateListener listener) {
        Log.d("ljm", "addPDFOperateListener");
        if (mListeners != null && listener != null) {
            mListeners.add(listener);
        }
    }

    @Override
    public void setThePageNumber(String number) {

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mListeners != null) {
            mListeners.clear();
        }
    }
}
