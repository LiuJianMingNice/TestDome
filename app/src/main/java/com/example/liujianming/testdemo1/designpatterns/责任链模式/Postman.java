package com.example.liujianming.testdemo1.designpatterns.责任链模式;

public abstract class Postman {
    protected Postman nextPosman;

    public abstract void handleCourier(String address);
}
