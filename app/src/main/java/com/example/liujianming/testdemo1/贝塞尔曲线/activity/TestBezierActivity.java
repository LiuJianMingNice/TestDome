package com.example.liujianming.testdemo1.贝塞尔曲线.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.贝塞尔曲线.customview.LikeStart;
import com.example.liujianming.testdemo1.贝塞尔曲线.customview.MyCircleView;
import com.example.liujianming.testdemo1.贝塞尔曲线.customview.MyView1;

public class TestBezierActivity extends AppCompatActivity {

    private Button click;
    private MyView1 myView1;
    private MyCircleView myCircleView;
    private LikeStart likeStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_bezier);
        setContentView(R.layout.activity_test_bezier1);

        click = findViewById(R.id.click);
        likeStart = findViewById(R.id.view);
//        myCircleView = findViewById(R.id.view);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                likeStart.startRunning();
            }
        });

    }
}