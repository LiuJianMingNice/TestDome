package com.example.liujianming.testdemo1.designpatterns.访问者模式;

public abstract class Web {

    public String name;

    public Web(String name) {
        this.name = name;
    }

    public abstract void accept(Visitor visitor);

    public abstract void download();

    public String getName() {
        return name;
    }
}
