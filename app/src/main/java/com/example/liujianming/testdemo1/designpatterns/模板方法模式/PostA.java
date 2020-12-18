package com.example.liujianming.testdemo1.designpatterns.模板方法模式;

public class PostA extends Postman {

    @Override
    protected void call() {
        System.out.println("联系A先生并送到门口");
    }
}
