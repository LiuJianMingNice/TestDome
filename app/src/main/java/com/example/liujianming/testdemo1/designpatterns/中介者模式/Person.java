package com.example.liujianming.testdemo1.designpatterns.中介者模式;

public abstract class Person {
    protected HouseMediator houseMediator;

    public Person(HouseMediator houseMediator) {
        this.houseMediator = houseMediator;
    }

    public abstract void send(String message);
    public abstract void getNotice(String message);
}
