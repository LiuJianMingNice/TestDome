package com.example.liujianming.testdemo1.designpatterns.状态模式;

public class LoveState implements PersonState {
    @Override
    public void movies() {
        System.out.println("一起上电影院看大片");
    }

    @Override
    public void shopping() {
        System.out.println("一起愉快的逛街去");
    }
}
