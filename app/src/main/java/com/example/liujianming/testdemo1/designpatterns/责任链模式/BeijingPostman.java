package com.example.liujianming.testdemo1.designpatterns.责任链模式;

public class BeijingPostman extends Postman {
    @Override
    public void handleCourier(String address) {
        if (address.equals("Beijing")) {
            System.out.println("派送到北京");
            return;
        } else {
            nextPosman.handleCourier(address);
        }
    }
}
