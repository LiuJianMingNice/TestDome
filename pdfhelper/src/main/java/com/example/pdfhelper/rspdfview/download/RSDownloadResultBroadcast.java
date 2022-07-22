package com.example.pdfhelper.rspdfview.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.pdfhelper.rspdfview.interfaces.IDownloadCallback;

import static com.example.pdfhelper.rspdfview.constants.Constants.DOWNLOAD_RESULT;
import static com.example.pdfhelper.rspdfview.constants.Constants.DOWNLOAD_STATE;
import static com.example.pdfhelper.rspdfview.constants.Constants.DownloadState.COMPLETE;
import static com.example.pdfhelper.rspdfview.constants.Constants.DownloadState.FAIL;
import static com.example.pdfhelper.rspdfview.constants.Constants.DownloadState.SUCCESS;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * RSDownloadResultBroadcast
 *
 * @author liujianming
 * @date 2022-07-20
 */
public class RSDownloadResultBroadcast extends BroadcastReceiver {

    IDownloadCallback mCallback;

    public void setResultCallback(IDownloadCallback callback) {
        mCallback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int state = intent.getIntExtra(DOWNLOAD_STATE, COMPLETE);
        String resultPath = intent.getStringExtra(DOWNLOAD_RESULT);
        if (mCallback != null) {
            switch (state) {
                case SUCCESS:
                    mCallback.downloadSuccess(resultPath);
                    break;
                case FAIL:
                    mCallback.downloadFail();
                    break;
                case COMPLETE:
                    mCallback.downloadFinish(resultPath);
                    break;
            }
        }
    }
}
