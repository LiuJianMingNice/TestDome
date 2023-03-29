package com.example.liujianming.testdemo1.android.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class NotificationTabItemViewModel {

    public final ObservableField<String> observeTypeName = new ObservableField<>();
    public final ObservableInt observeCount = new ObservableInt();
    public final ObservableBoolean observeSelected = new ObservableBoolean();

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
