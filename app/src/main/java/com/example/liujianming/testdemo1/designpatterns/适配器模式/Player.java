package com.example.liujianming.testdemo1.designpatterns.适配器模式;

public abstract class Player {
    protected String name;
    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();
    public abstract void Defense();
}
