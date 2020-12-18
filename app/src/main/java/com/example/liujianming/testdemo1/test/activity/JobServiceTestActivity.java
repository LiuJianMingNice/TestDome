package com.example.liujianming.testdemo1.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.test.service.MyJobService;

public class JobServiceTestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int JOB_INFO_ID = 10001;

    private static final long JOB_PERIODIC = 5 * 1000L;

    private Button btn_click;

    private JobScheduler mJobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_service_test);
        btn_click = findViewById(R.id.click_service);
        mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ljm","11111");
//                JobInfo.Builder builder = new JobInfo.Builder(1,new ComponentName(getPackageName(),MyJobService.class.getName()));
//                builder.setMinimumLatency(2000000);
                JobInfo jobInfo = new JobInfo.Builder(1, new ComponentName(getPackageName(), MyJobService.class.getName()))
                        .setOverrideDeadline(5000)
                        .setMinimumLatency(3000)
                        .build();
//                startService();
            }
        });
    }

    private void startService() {
        Intent intent = new Intent(JobServiceTestActivity.this, MyJobService.class);
        intent.setAction("android.intent.action.RESPOND_VIA_MESSAGE");
        JobServiceTestActivity.this.startService(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_service:
//                onJobStartClick();
//                JobInfo.Builder builder = new JobInfo.Builder(1,new ComponentName(getPackageName(),MyJobService.class.getName()));
//                builder.setMinimumLatency(2000);

                break;
            default:
                break;
        }
    }

    private void onJobStartClick() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName componentName = new ComponentName(this,MyJobService.class);

        JobInfo jobInfo = new JobInfo.Builder(JOB_INFO_ID,componentName)
                            .setPeriodic(JOB_PERIODIC)
                            .build();
    }

}
