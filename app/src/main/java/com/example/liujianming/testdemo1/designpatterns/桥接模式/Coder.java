package com.example.liujianming.testdemo1.designpatterns.桥接模式;

public class Coder extends Person {
    @Override
    protected void dress() {
        System.out.println("程序员穿上" + mClothes.getName());
    }
}
