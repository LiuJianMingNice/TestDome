package com.example.liujianming.testdemo1.android.model;

import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;

import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.liujianming.testdemo1.R;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

public class RecyclerViewItemModel implements MultiItemEntity {

    // 0: 不带开关 1:带开关
    private int showType;

    public final ObservableBoolean isOpenSwitch = new ObservableBoolean(false);

    public ObservableField<String> getTitle() {return title;}

    ObservableField<String> title = new ObservableField<>();

    public RecyclerViewItemModel(String label, int showType) {
        title.set(label);
        this.showType = showType;
    }

    @Override
    public int getItemType() {
        return showType;
    }

    private Boolean isTouched = false;

    public Boolean onSwitchTouch(View view, MotionEvent event) {
        isTouched = true;
        return false;
    }

    public void onSwitchChange(CompoundButton compoundButton, boolean isChecked) {
        if (isTouched) {
            isTouched = false;
            if(Utils.getApp().getString(R.string.recyclerview_item1).equals(title.get())){
                isOpenSwitch.set(isChecked);
            } else if(Utils.getApp().getString(R.string.recyclerview_item3).equals(title.get())){
                isOpenSwitch.set(isChecked);
            }
        }
    }
}
