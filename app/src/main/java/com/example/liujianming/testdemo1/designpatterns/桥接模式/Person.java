package com.example.liujianming.testdemo1.designpatterns.桥接模式;

public abstract class Person {
    Clothes mClothes;

    public void setClothes(Clothes clothes) {
        mClothes = clothes;
    }

    protected abstract void dress();
}
