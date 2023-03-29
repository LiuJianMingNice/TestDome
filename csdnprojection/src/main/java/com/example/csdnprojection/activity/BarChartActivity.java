package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.csdnprojection.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {
    private BarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        mChart = findViewById(R.id.chart);
        showChart(getBarData());
    }

    private void showChart(BarData barData) {
        //设置描述
        mChart.setDescription("测试柱状图");
        //设置可触摸
        mChart.setTouchEnabled(true);
        //设置图表数据
        mChart.setData(barData);
        //设置动画
        mChart.animateY(1000);
    }

    private BarData getBarData() {
        ArrayList<String> xValues = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            xValues.add((i + 1) + "季度");
        }

        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();

        float quarterly1 = 456787;
        float quarterly2 = 534283;
        float quarterly3 = 345734;
        float quarterly4 = 658465;

        yValues.add(new BarEntry(quarterly1, 0));
        yValues.add(new BarEntry(quarterly2, 1));
        yValues.add(new BarEntry(quarterly3, 2));
        yValues.add(new BarEntry(quarterly4, 3));

        BarDataSet barDataSet = new BarDataSet(yValues, "2017年季度收入");

        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        
        barDataSet.setColors(colors);

        BarData barData = new BarData(xValues, barDataSet);

        return barData;
    }
}