package com.example.liujianming.testdemo1.audioandvideo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceHolder;

import com.example.liujianming.testdemo1.R;

public class CameraActivity extends AppCompatActivity {

    private SurfaceHolder mSurfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


    }
}