package com.example.liujianming.testdemo1.designpatterns.代理模式;

public class Domestic implements People {
    @Override
    public void buy() {
        System.out.println("国内买一个包");
    }
}
