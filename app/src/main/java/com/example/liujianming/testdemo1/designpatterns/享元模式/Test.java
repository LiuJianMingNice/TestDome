package com.example.liujianming.testdemo1.designpatterns.享元模式;

public class Test {
    public static void main(String[] args) {
        BikeFactory factory = new BikeFactory();
        IBike ofo = factory.getBike("ofo");
        ofo.billing(2);
        IBike mobike = factory.getBike("Mobike");
        mobike.billing(1);
        IBike ofo1 = factory.getBike("ofo");
        ofo1.billing(3);
    }
}
