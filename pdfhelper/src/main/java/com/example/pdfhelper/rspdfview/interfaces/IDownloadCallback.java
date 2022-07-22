package com.example.pdfhelper.rspdfview.interfaces;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * IDownloadCallback
 *
 * @author liujianming
 * @date 2022-07-20
 */
public interface IDownloadCallback {
    void downloadSuccess(String savePath);

    void downloadFail();

    void downloadFinish(String savePath);
}
