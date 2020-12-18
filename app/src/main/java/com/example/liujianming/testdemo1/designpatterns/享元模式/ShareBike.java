package com.example.liujianming.testdemo1.designpatterns.享元模式;

import com.example.liujianming.testdemo1.designpatterns.享元模式.IBike;

public class ShareBike implements IBike {
    private int price = 1;
    private  int total;


    @Override
    public void billing(int time) {
        total = price * time;
        System.out.println("汽车花费了" + total + "元");
    }
}
