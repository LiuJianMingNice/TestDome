package com.example.liuwangshu.light.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.liuwangshu.R;
import com.example.liuwangshu.light.customwidget.CustomView;

public class TestCustomViewActivity extends AppCompatActivity {

    CustomView mCustomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_view);
        mCustomView = findViewById(R.id.custom);
        mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        ObjectAnimator.ofFloat(mCustomView,"translationX", 0 ,300).setDuration(1000).start();
    }
}