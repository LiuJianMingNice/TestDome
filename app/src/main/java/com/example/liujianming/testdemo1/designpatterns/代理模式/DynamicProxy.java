package com.example.liujianming.testdemo1.designpatterns.代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object obj;

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("海外动态代理调用方法: " + method.getName());
        Object result = method.invoke(obj,args);
        return result;
    }
}
