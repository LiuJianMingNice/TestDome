package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.csdnprojection.R;

public class MPAndroidChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_p_android_chart);
    }

    public void showPieChart(View view) {
        startActivity(new Intent(MPAndroidChartActivity.this, PieChartActivity.class));
    }

    public void showBarChart(View view) {
        startActivity(new Intent(MPAndroidChartActivity.this, BarChartActivity.class));
    }

    public void showLineChart(View view) {
        startActivity(new Intent(MPAndroidChartActivity.this, LineChartActivity.class));
    }

    public void showDynamicLineChart(View view) {
        startActivity(new Intent(MPAndroidChartActivity.this, DynamicLineChartActivity.class));
    }
}