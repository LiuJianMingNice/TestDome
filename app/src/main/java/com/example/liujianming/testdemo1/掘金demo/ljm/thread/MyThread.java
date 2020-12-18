package com.example.liujianming.testdemo1.掘金demo.ljm.thread;

public class MyThread extends Thread {
    private SynchronizedObject synchronizedObject;
    public MyThread(SynchronizedObject synchronizedObject) {
        this.synchronizedObject = synchronizedObject;
    }

    public void run() {
//        synchronizedObject.printString("b", "bb");
        while(true) {
            if (this.isInterrupted()) {
                System.out.println("线程已经终止，for循环不再执行");
                return;
            }
            System.out.println("Time=" + System.currentTimeMillis());
        }
    }
}
