package com.example.liujianming.testdemo1.designpatterns.适配器模式;

public class Translator extends Player {
    private ForeignCenter wjzf = new ForeignCenter();
    public Translator(String name) {
        super(name);
        wjzf.Name = name;
    }

    @Override
    public void Attack() {
        wjzf.进攻();
    }

    @Override
    public void Defense() {
        wjzf.防守();
    }
}
