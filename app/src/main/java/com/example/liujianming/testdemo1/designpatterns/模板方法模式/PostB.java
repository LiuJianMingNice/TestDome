package com.example.liujianming.testdemo1.designpatterns.模板方法模式;

public class PostB extends Postman {

    @Override
    protected void call() {
        System.out.println("联系B先生并送到门口");
    }

    @Override
    protected boolean isSign() {
        return false;
    }

    @Override
    protected void refuse() {
        System.out.println("拒绝签收，商品不符");
    }
}
