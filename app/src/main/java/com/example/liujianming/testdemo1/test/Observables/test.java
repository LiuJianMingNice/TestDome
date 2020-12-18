package com.example.liujianming.testdemo1.test.Observables;


import java.util.Observable;
import java.util.Observer;

public class test {

    public static void main(String[] args) {
        test();
    }


    public static void test() {
        ObservableTest postman = new Postman();

        ObserverTest boy1 = new Boy("路飞");
        ObserverTest boy2 = new Boy("乔巴");
        ObserverTest girl1 = new Girl("娜美");

        postman.add(boy1);
        postman.add(boy2);
        postman.add(girl1);

        postman.notify("快递到了，请下楼领取.");
    }

}
