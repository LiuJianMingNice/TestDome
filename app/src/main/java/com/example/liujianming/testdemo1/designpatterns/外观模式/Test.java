package com.example.liujianming.testdemo1.designpatterns.外观模式;

public class Test {
    public static void main(String[] args) {
        GameSdk gameSdk = new GameSdk();
        gameSdk.login();
        gameSdk.pay(6);
    }
}
