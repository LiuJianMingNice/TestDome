package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;
import android.util.ArrayMap;
import android.util.SparseArray;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.annotation.RequiresApi;
import dalvik.system.BaseDexClassLoader;

/**
 * ClassName:TestThread
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-18
 * @author:liujianming
 */
public class TestThread {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) throws InterruptedException {

//        System.out.println("main start...");
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("thread run...");
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                }
//                System.out.println("thread end.");
//            }
//        };
//        thread.start();
//        try {
//            Thread.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("main end...");

//        openThreadForThread();
//        openThreadForRunnable();
//        openThreadForLambda();
//        testJoin();
//        testTimerThread();
//        testCounterThread();
//        testSynchronized();
//        testTask();
        testForkJoin();
    }
    private static void openThreadForThread() {
        Thread thread = new MyThread();
        thread.start();
    }
    private static void openThreadForRunnable() {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    private static void openThreadForLambda() {
        Thread thread = new Thread(() ->{
            System.out.println("简化开启线程！");
        });
        thread.start();
    }

    private static void testJoin() throws InterruptedException {
        Thread thread = new MyThread1();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();//中断thread线程
        thread.join();//等thread线程结束
        System.out.println("end");
    }

    private static void testTimerThread() {
        Thread thread = new TimerThread();
        thread.setDaemon(true);
        thread.start();
    }

    private static void testCounterThread() throws InterruptedException {
        Thread addThread = new AddThread();
        Thread decThread = new DecThread();
        addThread.start();
        decThread.start();
        addThread.join();
        decThread.join();
        System.out.println(Counter.count);
    }

    private static void testSynchronized() throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String s = taskQueue.getTask();
                            System.out.println("execute task: " + s);
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            };
            thread.start();
            list.add(thread);
        }
        Thread addThread = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                taskQueue.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        addThread.start();
        addThread.join();
        Thread.sleep(100);
        for (Thread thread : list) {
            thread.interrupt();
        }
    }

    private static void testTask() {
        ExecutorService es = Executors.newFixedThreadPool(4);
        ExecutorService es1 = Executors.newCachedThreadPool();
        ExecutorService es2 = new ThreadPoolExecutor(4, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        es.shutdown();
    }

    private static void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //定义任务
        Callable<String> task = new CallableTask();
        //提交任务并获得Future
        Future<String> future = executorService.submit(task);
        //从Future获取异步执行返回的结果
        String result = future.get();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testForkJoin() {
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/Join sum: " + result + " in " + (endTime - startTime) + "ms.");
    }
    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread开启线程!");
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start();//启动hello线程
        try {
            hello.join();//等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while(!isInterrupted()) {
            n++;
            System.out.println(n + "hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class TimerThread extends Thread {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("用Runnable开启线程！");
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws Exception {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end task " + name);
    }
}

class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return null;
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 500;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
        int middle = (end + start) / 2;
        System.out.println(String.format("sqlit %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle,end));
        SumTask sumTak1 = new SumTask(this.array, start, middle);
        SumTask sumTak2 = new SumTask(this.array, middle, end);
        invokeAll(sumTak1, sumTak2);
        Long subResult1 = sumTak1.join();
        Long subResult2 = sumTak2.join();
        Long result = subResult1 + subResult2;
        System.out.println("result = " + subResult1 + " + " + subResult2 + " ===> " + result);
        return result;
    }
}
