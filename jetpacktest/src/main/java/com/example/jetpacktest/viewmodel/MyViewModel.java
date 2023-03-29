package com.example.jetpacktest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 * <p>
 * MyViewModel
 *
 * @author liujianming
 * @date 2022-10-10
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<String> name;
    public LiveData<String> getName() {
        if (name == null) {
            name = new MutableLiveData<String>();
            addName();
        }
        return name;
    }
    private void addName() {
        name.setValue("Android进阶解密");
    }
}
