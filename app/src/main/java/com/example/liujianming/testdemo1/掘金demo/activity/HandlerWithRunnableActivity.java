package com.example.liujianming.testdemo1.掘金demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;

public class HandlerWithRunnableActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView statusTextView;
    private Button download;
    private Handler mHandler = new Handler();
    private static String TAG = "ljm";
    private Handler mHandler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.d(TAG, "Runnable thread id = " + Thread.currentThread().getId());
                    HandlerWithRunnableActivity.this.statusTextView.setText("文件下载完成!!!!!");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_with_runnable);
        statusTextView = findViewById(R.id.text1);
        download = findViewById(R.id.click_download);
        download.setOnClickListener(this);
        Log.d(TAG,"Main thread id = " + Thread.currentThread().getId());
    }

    @Override
    public void onClick(View v) {
//        DownloadThread downloadThread = new DownloadThread();
//        downloadThread.start();
        DownloadTrhead1 downloadTrhead1 = new DownloadTrhead1();
        downloadTrhead1.start();
    }

    class DownloadThread extends Thread {
        @Override
        public void run() {

            try {
                Log.d(TAG, "DownloadThread id = " + Thread.currentThread().getId());
                Log.d(TAG, "开始下载文件");
                Thread.sleep(5000);
                Log.d(TAG, "文件下载完成");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Runnable thread id = " + Thread.currentThread().getId());
                        HandlerWithRunnableActivity.this.statusTextView.setText("文件下载完成");
                    }
                };
                mHandler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class DownloadTrhead1 extends Thread {
        @Override
        public void run() {
            try {
                Log.d(TAG, "DownloadThread id = " + Thread.currentThread().getId());
                Log.d(TAG, "开始下载文件");
                Thread.sleep(5000);
                Log.d(TAG, "文件下载完成");
                Message msg = new Message();
                msg.what = 1;
                mHandler1.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //精确获取页面绘制时间
    @Override
    protected void onResume() {
        super.onResume();
        final long start = System.currentTimeMillis();
        //方法一
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.d(TAG, "方法一===>>>onRender cost: " + (System.currentTimeMillis() - start));
                return false;
            }
        });

        //方法二
        getWindow().getDecorView().post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "方法二===>>>onRender cost: " + (System.currentTimeMillis() - start));
            }
        });
    }
}