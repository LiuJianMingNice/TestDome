package com.example.liuwangshu.test.ljm;

/**
 * ClassName:Thread
 * Package:com.example.liuwangshu.test.ljm
 *
 * @date:21-6-22
 * @author:liujianming
 */
public class TestThread {

    public void test1() {
        synchronized (this) {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void test2() {
        int i = 5;
        while(i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final TestThread thread = new TestThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread.test2();
            }
        }, "t1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                thread.test2();
            }
        }, "t2");
        thread1.start();
        thread2.start();
    }
}
