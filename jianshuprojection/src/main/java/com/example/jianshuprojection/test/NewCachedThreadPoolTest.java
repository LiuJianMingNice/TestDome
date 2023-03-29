package com.example.jianshuprojection.test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask1 implements Callable<String> {

    private int id;

    public MyTask1(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("id:" + id + " - threadName:" + Thread.currentThread().getName() + "调用call方法");
        //这里返回的结果，会被Future的get方法得到
        return "任务返回结果为：" + id + " - " + Thread.currentThread().getName();
    }
}

public class NewCachedThreadPoolTest {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        //存储返回的结果
        ArrayList<Future<String>> list = new ArrayList<>();

        //提交10个任务，并将返回的future存储
        for (int i = 0; i < 10; i++) {
            Future<String> future = pool.submit(new MyTask1(i));
            list.add(future);
        }

        for (Future<String> fs : list) {
            //Future 返回如果没有完成，则一直循环
            while (!fs.isDone());
            System.out.println(fs.get());
            pool.shutdown();
        }
    }

}
