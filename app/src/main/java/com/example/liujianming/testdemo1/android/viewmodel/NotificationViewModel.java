package com.example.liujianming.testdemo1.android.viewmodel;

import android.content.Context;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

public class NotificationViewModel {
    private static final String TAG = NotificationViewModel.class.getSimpleName();
    private final Context mContext;


    private List<NotificationTabItemViewModel> tabList = new ArrayList<>();
    private SparseArray<NotificationTabItemViewModel> tabSparseArray = new SparseArray<>();

    public NotificationViewModel(Context mContext) {
        this.mContext = mContext;
    }
}
