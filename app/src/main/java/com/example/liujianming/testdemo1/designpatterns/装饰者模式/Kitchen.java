package com.example.liujianming.testdemo1.designpatterns.装饰者模式;

public class Kitchen extends RoomDecorator {

    public Kitchen(Room mRroom) {
        super(mRroom);
    }

    @Override
    public void fitment() {
        super.fitment();
        addKitchenware();
    }

    private void addKitchenware() {
        System.out.println("装修成厨房：添加厨具");
    }
}
