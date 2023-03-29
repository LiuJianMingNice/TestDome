package com.example.liujianming.testdemo1.android.interfaces;

import com.example.liujianming.testdemo1.android.bean.SegmentedControlItem;

public interface ISegmentedControl {

    int getCount();

    SegmentedControlItem getItem(int position);

    String getName(int position);

}
