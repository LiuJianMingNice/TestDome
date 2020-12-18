package com.example.liujianming.testdemo1.designpatterns.命令模式;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        System.out.println("调用者执行命令");
        command.execute();
    }
}
