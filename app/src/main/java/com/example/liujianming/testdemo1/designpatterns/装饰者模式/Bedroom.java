package com.example.liujianming.testdemo1.designpatterns.装饰者模式;

public class Bedroom extends RoomDecorator {

    public Bedroom(Room mRroom) {
        super(mRroom);
    }

    @Override
    public void fitment() {
        super.fitment();
        addBedding();
    }

    private void addBedding() {
        System.out.println("装修成卧室：添加卧具");
    }
}
