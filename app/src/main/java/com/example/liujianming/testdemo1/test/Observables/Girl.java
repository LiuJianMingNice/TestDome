package com.example.liujianming.testdemo1.test.Observables;

public class Girl implements ObserverTest {

    private String name;
    public Girl(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + ",收到了信息：" + message + "让男朋友去取快递");
    }
}
