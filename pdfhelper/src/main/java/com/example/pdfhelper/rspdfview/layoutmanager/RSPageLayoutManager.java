package com.example.pdfhelper.rspdfview.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.pdfhelper.pdfview.utils.layoutmanager.PagerChangedListener;
import com.example.pdfhelper.rspdfview.interfaces.IPageChangedListener;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSPageLayoutManager
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSPageLayoutManager extends LinearLayoutManager {

    private final String TAG = this.getClass().getSimpleName();

    private RecyclerView mRecyclerView;
    private SnapHelper mPageSnapHelper;
    private IPageChangedListener mPageChangedListener;
    private int mDrift;

    public RSPageLayoutManager(Context context, int orientation) {
        super(context, orientation, false);
        init();
    }

    public RSPageLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        init();
    }

    private void init() {
        mPageSnapHelper = new MyPagerSnapHelper();
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        mRecyclerView = view;
        mPageSnapHelper.attachToRecyclerView(view);
        mRecyclerView.addOnChildAttachStateChangeListener(mChildAttachStateChangeListener);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    /**
     * 滑动状态的改变
     * 缓慢拖拽-> SCROLL_STATE_DRAGGING
     * 快速滚动-> SCROLL_STATE_SETTLING
     * 空闲状态-> SCROLL_STATE_IDLE
     */
    @Override
    public void onScrollStateChanged(int state) {
        Log.d("ljm", "state: " + state);
        switch (state) {
            case RecyclerView.SCROLL_STATE_IDLE:
                View view = mPageSnapHelper.findSnapView(this);
                if (view == null) {
                    return;
                }
                int position = getPosition(view);
                if (mPageChangedListener != null && getChildCount() == 1) {
                    mPageChangedListener.onPageSelected(position, position == getItemCount() - 1);
                }
                break;
        }
    }

    /** 监听竖直方向的相对偏移量 */
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = dy;
        return super.scrollVerticallyBy(dy, recycler, state);
    }


    /** 监听水平方向的相对偏移量 */
    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = dx;
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    /** 设置监听 */
    public void setOnPagerChangeListener(IPageChangedListener listener) {
        this.mPageChangedListener = listener;
    }

    private RecyclerView.OnChildAttachStateChangeListener mChildAttachStateChangeListener
            = new RecyclerView.OnChildAttachStateChangeListener() {

        @Override
        public void onChildViewAttachedToWindow(View view) {
            if (mPageChangedListener != null && getChildCount() == 1) {
                mPageChangedListener.onInitFinish();
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {
            if (mDrift >= 0) {
                if (mPageChangedListener != null) {
                    mPageChangedListener.onReleaseListener(true, getPosition(view));
                }
            } else {
                if (mPageChangedListener != null) {
                    mPageChangedListener.onReleaseListener(false, getPosition(view));
                }
            }
        }
    };

    /** 获取当前的页面下标 */
    public int getCurrentPosition() {
        View view = mPageSnapHelper.findSnapView(this);
        return view == null ? -1 : getPosition(view);
    }
}
