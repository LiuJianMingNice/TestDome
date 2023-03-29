package com.example.openglproject;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLES20;
import android.os.Bundle;

import com.example.openglproject.customview.OneGLSurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        OneGLSurfaceView oneGLSurfaceView = new OneGLSurfaceView(this);
        setContentView(oneGLSurfaceView);

    }
}
