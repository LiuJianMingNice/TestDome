package com.example.liujianming.testdemo1.designpatterns.装饰者模式;

public class NewRoom extends Room {
    @Override
    public void fitment() {
        System.out.println("这是一间装上电的新房子");
    }
}
