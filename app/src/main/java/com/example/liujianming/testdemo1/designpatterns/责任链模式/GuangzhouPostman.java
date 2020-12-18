package com.example.liujianming.testdemo1.designpatterns.责任链模式;

public class GuangzhouPostman extends Postman {
    @Override
    public void handleCourier(String address) {
        if (address.equals("Guangzhou")) {
            System.out.println("派送到广州");
            return;
        } else {
            nextPosman.handleCourier(address);
        }
    }
}
