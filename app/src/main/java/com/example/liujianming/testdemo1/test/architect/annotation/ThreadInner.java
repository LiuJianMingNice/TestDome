package com.example.liujianming.testdemo1.test.architect.annotation;

import java.util.Timer;
import java.util.TimerTask;

public class ThreadInner implements Runnable{

    private volatile boolean readly = true;
    private int count = 0;

    @Override
    public void run() {
        while (readly) {

            Timer timer = new Timer();// 实例化Timer类
            timer.schedule(new TimerTask() {
                public void run() {
                    count = count + 2;
                    System.out.println("count==>>> " + count);
                    timeCount();
                }
            }, 1000);// 这里百毫秒

        }
    }

    public void timeCount(){
        readly = false;
    }
}
