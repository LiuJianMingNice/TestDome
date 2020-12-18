package com.example.liujianming.testdemo1.掘金demo.ljm.thread;

public class Run {
    public static void main(String args[]) throws InterruptedException{
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        Thread thread = new MyThread(synchronizedObject);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        System.out.println(synchronizedObject.getName() + " " + synchronizedObject.getPassword());
    }
}
