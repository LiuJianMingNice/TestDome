package com.example.liujianming.testdemo1.test.Observables;



public class Boy implements ObserverTest {

    private String name;
    public Boy(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + ",收到了信息：" + message + "屁颠屁颠的去取快递");
    }
}
