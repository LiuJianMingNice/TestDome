package com.example.liujianming.testdemo1.designpatterns.策略模式;

public class EattingStrategy implements ChaseStragety {
    @Override
    public void chase() {
        System.out.println("一起吃饭");
    }
}
