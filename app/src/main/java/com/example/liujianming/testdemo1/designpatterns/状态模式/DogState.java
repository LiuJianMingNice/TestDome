package com.example.liujianming.testdemo1.designpatterns.状态模式;

public class DogState implements PersonState {
    @Override
    public void movies() {
        System.out.println("一个人看国产大片");
    }

    @Override
    public void shopping() {

    }
}
