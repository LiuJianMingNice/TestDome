package com.example.liujianming.testdemo1.designpatterns.模板方法模式;

public abstract class Postman {

    public final void post() {
        prepare();
        call();
        if (isSign()) {
            sign();
        } else {
            refuse();
        }
    }

    protected void prepare() {
        System.out.println("快递到了，准备派送");
    }

    protected abstract void call();

    protected boolean isSign() {
        return true;
    }

    protected void sign() {
        System.out.println("客户已签收，上报系统");
    }

    protected void refuse() {

    }

}
