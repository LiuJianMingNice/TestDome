package com.example.liujianming.testdemo1.designpatterns.装饰者模式;

public class RoomDecorator extends Room {

    private Room mRroom;

    public RoomDecorator(Room mRroom) {
        this.mRroom = mRroom;
    }

    @Override
    public void fitment() {
        mRroom.fitment();
    }
}
