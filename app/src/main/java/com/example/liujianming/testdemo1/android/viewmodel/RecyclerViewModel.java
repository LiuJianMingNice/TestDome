package com.example.liujianming.testdemo1.android.viewmodel;

import com.blankj.utilcode.util.Utils;
import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.model.RecyclerViewItemModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BaseObservable;

public class RecyclerViewModel extends BaseObservable {

    public List<RecyclerViewItemModel> mRecyclerViewItemModels = new ArrayList<>();

    int LOCAL_TYPE_0 = 0;
    int LOCAL_TYPE_1 = 1;

    public RecyclerViewModel() {
    }

    public void initData() {
        mRecyclerViewItemModels.clear();
        String[] configValue = Utils.getApp().getResources().getStringArray(R.array.recyclerview_config);

        for (String s : configValue) {
            RecyclerViewItemModel model;
            if (Utils.getApp().getString(R.string.recyclerview_item1).equals(s)) {
                model = new RecyclerViewItemModel(s, LOCAL_TYPE_1);
                model.isOpenSwitch.set(true);
            } else if (Utils.getApp().getString(R.string.recyclerview_item2).equals(s)) {
                model = new RecyclerViewItemModel(s, LOCAL_TYPE_1);
                model.isOpenSwitch.set(false);
            } else {
                model = new RecyclerViewItemModel(s, LOCAL_TYPE_0);
            }
            mRecyclerViewItemModels.add(model);
        }
    }
}
