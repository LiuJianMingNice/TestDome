package com.example.liujianming.testdemo1.designpatterns.策略模式;

public class Context {

    private ChaseStragety chaseStragety;

    public Context(ChaseStragety chaseStragety) {
        this.chaseStragety = chaseStragety;
    }

    public void chase() {
        chaseStragety.chase();
    }
}
