package com.example.liujianming.testdemo1.designpatterns.命令模式;

public class Test {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ShutdownCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
