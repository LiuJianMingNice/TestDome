package com.example.liujianming.testdemo1.designpatterns.命令模式;

public class Receiver {
    public void action() {
        System.out.println("接收者执行具体的操作");
        System.out.println("开始执行关机操作");
        System.out.println("退出所有程序进程");
        System.out.println("关机～");
    }
}
