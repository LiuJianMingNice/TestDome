package com.example.pdfhelper.pdfview.download;

/**
 * Date: 2021/1/26
 * Author: Yang
 * Describe:
 */
public interface IDownloadCallback {

    void downloadSuccess(String path);

    void downloadFail();

    void downloadComplete(String path);

}
