package com.example.jianshuprojection.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ThreadPoolUtil implements Runnable {

    private Integer index;

    public ThreadPoolUtil(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            System.out.println(index + "开始处理线程！");
            Thread.sleep(5000);
            System.out.println("线程标示是：" + this.toString());
            System.out.println(index + "处理结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NewScheduledThreadPoolTest {
    public static void main(String[] args) throws Exception {
        //核心线程为2，一次执行2个任务，剩下的放入到队列
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 4; i++) {
            pool.schedule(new ThreadPoolUtil(i), 2, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }
}
