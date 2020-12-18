package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.customview.MyPointView;

public class MyPointViewActivity extends AppCompatActivity {

    private Button btnStart;
    private MyPointView mMyPointView;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_point_view);

        btnStart = findViewById(R.id.btn);
        mMyPointView = findViewById(R.id.point_view);
        tv = findViewById(R.id.tv);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doPointViewAnimation();
                changeTextViewColor();
            }
        });
    }

    private void doPointViewAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(mMyPointView, "pointRadius", 100);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    private void changeTextViewColor() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        objectAnimator.setDuration(8000);
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.start();
    }
}