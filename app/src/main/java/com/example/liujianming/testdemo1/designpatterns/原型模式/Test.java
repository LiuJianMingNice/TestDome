package com.example.liujianming.testdemo1.designpatterns.原型模式;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.test();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
