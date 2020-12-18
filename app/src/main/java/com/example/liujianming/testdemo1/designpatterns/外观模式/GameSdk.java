package com.example.liujianming.testdemo1.designpatterns.外观模式;

public class GameSdk {
    public void login() {
        LoginManager loginManager = new LoginManager();
        loginManager.login();
    }

    public void pay(int momey) {
        PayManager payManager = new PayManager();
        payManager.pay(momey);
    }
}
