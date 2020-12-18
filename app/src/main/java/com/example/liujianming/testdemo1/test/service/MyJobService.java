package com.example.liujianming.testdemo1.test.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class MyJobService extends JobService {

    private final String TAG = "MyJobService";

    public MyJobService() {
        Log.i(TAG,"无参构造函数");
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(MyJobService.this,"MyJobService", Toast.LENGTH_SHORT).show();
            JobParameters parameters = (JobParameters) msg.obj;
            jobFinished(parameters,true);
            return true;
        }
    });

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"====onStartCommand==>>>>>");
        return START_STICKY;
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG,"====onStartJob==>>>>>");
        Message m = Message.obtain();
        m.obj = params;
        handler.sendMessageDelayed(m,2000);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG,"====onStopJob==>>>>>");
        handler.removeCallbacksAndMessages(null);
        return false;
    }
}
