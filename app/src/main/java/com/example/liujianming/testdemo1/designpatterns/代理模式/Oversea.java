package com.example.liujianming.testdemo1.designpatterns.代理模式;

public class Oversea implements People {

    People mPeople;

    public Oversea(People mPeople) {
        this.mPeople = mPeople;
    }

    @Override
    public void buy() {
        System.out.println("我是海外代购");
        mPeople.buy();
    }
}
