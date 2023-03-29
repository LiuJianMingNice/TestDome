package com.example.jianshuprojection.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) {
        startThread1();
//        startThread2();
    }

    private static void startThread1() {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "进入");
                LockSupport.park();
                System.out.println("线程" + Thread.currentThread().getName() + "被唤醒");
            }
        }, "thread1");
        thread1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程" + Thread.currentThread().getName() + "进入");
                LockSupport.unpark(thread1);
                System.out.println("给" + thread1.getName() + "线程发了许可证");
            }
        }, "thread2");
        thread2.start();
    }

    private static void startThread2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!Thread.currentThread().isInterrupted()){
                        System.out.println("thread name:" + Thread.currentThread().getName());
                    } else {
                        return;
                    }
                }
            }
        });
        thread.start();
    }
}
