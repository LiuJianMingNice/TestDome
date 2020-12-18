package com.example.liujianming.testdemo1.arouter.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 7)
public class UseSecondIInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i("ljm", "UseSecondIInterceptor 拦截器 init:");
    }

    @Override
    public void init(Context context) {
        String name = Thread.currentThread().getName();
        Log.i("ljm","UseSecondIInterceptor 拦截器开始执行： " + "线程名字: " + name);
    }
}
