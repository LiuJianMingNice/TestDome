package com.example.liujianming.testdemo1.designpatterns.观察者模式;

public class Test {
    public static void main(String[] args) {
        Observable postman = new Postman();

        Observer boy1 = new Boy("路飞");
        Observer boy2 = new Boy("乔巴");
        Observer girl1 = new Girl("路飞");

        postman.add(boy1);
        postman.add(boy2);
        postman.add(girl1);

        postman.notify("快递到了，请下楼领取");
    }

}
