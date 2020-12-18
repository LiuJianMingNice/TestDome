package com.example.liujianming.testdemo1.designpatterns.责任链模式;

public class ShanghaiPostman extends Postman {
    @Override
    public void handleCourier(String address) {
        if (address.equals("Shanghai")) {
            System.out.println("派送到上海");
            return;
        } else {
            nextPosman.handleCourier(address);
        }
    }
}
