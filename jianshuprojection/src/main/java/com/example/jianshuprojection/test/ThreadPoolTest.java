package com.example.jianshuprojection.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        //定义一个容量为2的有界阻塞队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        //创建一个线程池，核心线程3个，最大线程数5个，60秒超时
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, queue);
        Runnable r1 = new MyTask();
        Runnable r2 = new MyTask();
        Runnable r3= new MyTask();
        Runnable r4 = new MyTask();
        Runnable r5 = new MyTask();
        Runnable r6 = new MyTask();
        Runnable r7 = new MyTask();
        Runnable r8 = new MyTask();

        threadPoolExecutor.execute(r1);
        threadPoolExecutor.execute(r2);
        threadPoolExecutor.execute(r3);
        threadPoolExecutor.execute(r4);
        threadPoolExecutor.execute(r5);
        threadPoolExecutor.execute(r6);
        threadPoolExecutor.execute(r7);
//        threadPoolExecutor.execute(r8);
        threadPoolExecutor.shutdown();
    }
}
