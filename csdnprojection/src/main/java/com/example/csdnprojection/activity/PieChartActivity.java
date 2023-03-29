package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.example.csdnprojection.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        mChart = findViewById(R.id.chart);
        showChart(getPieData());
    }

    private void showChart(PieData pieData) {
        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(60f);  //内环半径
        mChart.setTransparentCircleRadius(64f);  //半透明圈半径
        //mChart.setHoleRadius(0);  //实心圆
        mChart.setDescription("测试饼状图");
        mChart.setDrawCenterText(true);  //饼状图中间可以添加文字
        mChart.setCenterText("2017年季度收入");  //饼状图中间的文字
        mChart.setRotationAngle(90);  //初始旋转角度
        mChart.setDrawHoleEnabled(true);  //可以手动旋转
        //mChart.setUsePercentValues(true);  //显示成百分比
        //设置可触摸
        mChart.setTouchEnabled(true);
        //设置数据
        mChart.setData(pieData);

        //取消高亮显示
        mChart.highlightValues(null);
        mChart.invalidate();

        Legend mLegend = mChart.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);  //最右边显示
        mLegend.setForm(Legend.LegendForm.LINE);  //设置比例图的形状,默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

        //设置动画
        mChart.animateXY(1000,1000);
    }

    private PieData getPieData() {
        //xValues用来表示每个饼块上的文字
        ArrayList<String> xValues = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            xValues.add((i + 1) + "季度");
        }

        //yValues用来表示封装每个饼块的实际数据
        ArrayList<Entry> yValues = new ArrayList<Entry>();

        //饼图数据
        float quarterly1 = 456787;
        float quarterly2 = 534283;
        float quarterly3 = 345734;
        float quarterly4 = 658465;

        yValues.add(new Entry(quarterly1, 0));
        yValues.add(new Entry(quarterly2, 1));
        yValues.add(new Entry(quarterly3, 2));
        yValues.add(new Entry(quarterly4, 3));

        //y轴集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "2017年季度收入");
        pieDataSet.setSliceSpace(0f);  //设置每个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<Integer>();

        //饼图颜色
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));

        //设置饼图颜色
        pieDataSet.setColors(colors);

        //设置选中态多出的长度
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px);

        //创建饼图数据
        PieData pieData = new PieData(xValues, pieDataSet);
        return  pieData;
    }
}