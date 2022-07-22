package com.example.pdfhelper.pdfview.download;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.example.pdfhelper.pdfview.constants.Constants;
import com.example.pdfhelper.pdfview.utils.PdfLog;

import androidx.annotation.Nullable;


import static com.example.pdfhelper.pdfview.constants.Constants.DOWNLOAD_ACTION;
import static com.example.pdfhelper.pdfview.constants.Constants.DOWNLOAD_RESULT;
import static com.example.pdfhelper.pdfview.constants.Constants.DOWNLOAD_STATE;

/**
 * Date: 2021/1/26
 * Author: Yang
 * Describe:
 */
public class DownloadService extends IntentService {

    //下载地址
    public static final String DOWNLOAD_URL_KEY = "DOWNLOAD_URL_KEY";

    private String downLoadUrl;
    private DownloadManager downloadManager;


    public DownloadService() {
        super("download_pdf");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("ljm", "onHandleIntent");
        PdfLog.logDebug("onHandleIntent");
        if (intent != null) {
            downLoadUrl = intent.getStringExtra(DOWNLOAD_URL_KEY);
        }
        if (!TextUtils.isEmpty(downLoadUrl)){
            downloadManager = new DownloadManager(new IDownloadCallback() {
                @Override
                public void downloadSuccess(String resultPath) {
                    sendDownloadState(Constants.DownloadState.SUCCESS, resultPath);
                }

                @Override
                public void downloadFail() {
                    sendDownloadState(Constants.DownloadState.FAIL, "");
                }

                @Override
                public void downloadComplete(String path) {
                    sendDownloadState(Constants.DownloadState.COMPLETE, path);
                }
            });
            downloadManager.downloadFile(getApplicationContext(), downLoadUrl);
        }
    }

    private void sendDownloadState(int state, String path) {
        Log.d("ljm", "sendDownloadState");
        Intent it = new Intent();
        it.setAction(DOWNLOAD_ACTION);
        if (!TextUtils.isEmpty(path)) {
            it.putExtra(DOWNLOAD_RESULT, path);
        }
        it.putExtra(DOWNLOAD_STATE, state);
        sendBroadcast(it);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (downloadManager != null){
            downloadManager.cancel();
        }
    }
}
