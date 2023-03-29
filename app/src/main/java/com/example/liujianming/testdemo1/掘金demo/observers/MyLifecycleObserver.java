package com.example.liujianming.testdemo1.掘金demo.observers;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifecycleObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onForeground() {
        Log.d("ljm", "应用回到前台");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onBackGround() {
        Log.d("ljm", "应用回到后台");
    }
}
