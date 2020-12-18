package com.example.liujianming.testdemo1.贝塞尔曲线.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.贝塞尔曲线.customview.MyGiftView;

public class TestActivity extends AppCompatActivity {

    private Button button;
    private MyGiftView myGiftView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = findViewById(R.id.btn_click);
        myGiftView = findViewById(R.id.gift);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myGiftView.addImageView();
            }
        });
    }
}