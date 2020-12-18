package com.example.liujianming.testdemo1.掘金demo.ljm;

public class TestThread {

    public void testThread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        };
        thread.start();
    }

    public void testRunnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}

