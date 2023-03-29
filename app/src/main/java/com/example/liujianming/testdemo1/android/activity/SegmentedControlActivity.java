package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.bean.SegmentedControlItem;
import com.example.liujianming.testdemo1.android.customview.SegmentedControlView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SegmentedControlActivity extends AppCompatActivity {

    private SegmentedControlView mScv1, mScv2, mScv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segmented_control);

        mScv1 = findViewById(R.id.scv1);
        mScv2 = findViewById(R.id.scv2);
        mScv3 = findViewById(R.id.scv3);

        List<SegmentedControlItem> items = new ArrayList<>();
        items.add(new SegmentedControlItem("今天"));
        items.add(new SegmentedControlItem("明天"));
        items.add(new SegmentedControlItem("后天"));

        List<SegmentedControlItem> items1 = new ArrayList<>();
        items1.add(new SegmentedControlItem("一月"));
        items1.add(new SegmentedControlItem("二月"));
        items1.add(new SegmentedControlItem("三月"));
        items1.add(new SegmentedControlItem("四月"));


        mScv1.addItems(items);
        mScv2.addItems(items1);
        mScv3.addItems(items);

        mScv1.setOnSegItemClickListener(new SegmentedControlView.OnSegItemClickListener() {
            @Override
            public void onItemClick(SegmentedControlItem item, int position) {
                String msg = String.format(Locale.getDefault(), "click scv1:%d", position);
                Log.d("ljm", msg);
            }
        });

        mScv2.setOnSegItemClickListener(new SegmentedControlView.OnSegItemClickListener() {
            @Override
            public void onItemClick(SegmentedControlItem item, int position) {
                String msg = String.format(Locale.getDefault(), "click scv2:%d", position);
                Log.d("ljm", msg);
            }
        });

        mScv3.setOnSegItemClickListener(new SegmentedControlView.OnSegItemClickListener() {
            @Override
            public void onItemClick(SegmentedControlItem item, int position) {
                String msg = String.format(Locale.getDefault(), "click scv3:%d", position);
                Log.d("ljm", msg);
            }
        });
    }
}