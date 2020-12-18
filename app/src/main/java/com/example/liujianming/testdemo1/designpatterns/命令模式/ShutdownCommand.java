package com.example.liujianming.testdemo1.designpatterns.命令模式;

public class ShutdownCommand implements Command {
    private Receiver receiver;

    public ShutdownCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("命令角色执行关机命令");
        receiver.action();
    }
}
