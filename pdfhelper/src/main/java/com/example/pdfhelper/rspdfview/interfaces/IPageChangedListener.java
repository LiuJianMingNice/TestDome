package com.example.pdfhelper.rspdfview.interfaces;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * IPageChangedListener
 *
 * @author liujianming
 * @date 2022-07-20
 */
public interface IPageChangedListener {

    void onInitFinish();

    void onReleaseListener(boolean isNext, int position);

    void onPageSelected(int position, boolean isBottom);
}
