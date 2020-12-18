package com.example.liujianming.testdemo1.简书Demo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.简书Demo.customview.RadarView;

public class TestRadarViewActivity extends AppCompatActivity {

    private String[] titleArray = new String[] {"击杀", "生存", "助攻", "物理", "魔法", "金钱", "伤害"};
    private int[] scoreArray = new int[] {60, 92, 94, 30, 98, 68, 99};

    private RadarView mRadarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_radar_view);

        mRadarView = findViewById(R.id.radarview);
        mRadarView.setTitleArray(titleArray);
        mRadarView.setScoreArray(scoreArray);
    }
}