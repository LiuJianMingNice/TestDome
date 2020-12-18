package com.example.liujianming.testdemo1.test.architect.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AbaPro {

    private static final Random RANDOM = new Random();
    private static final String B = "B";
    private static final String A = "A";
    public static final AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<>(A);
    public static final AtomicStampedReference<String> ATOMIC_STAMPED_REFERENCE = new AtomicStampedReference<>(A,0);

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startLatch = new CountDownLatch(1);

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
//                    String oldValue = ATOMIC_REFERENCE.get();
                    String oldValue = ATOMIC_STAMPED_REFERENCE.getReference();
                    int stamp = ATOMIC_STAMPED_REFERENCE.getStamp();
                    try {
                        startLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(RANDOM.nextInt()&500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                    if(ATOMIC_REFERENCE.compareAndSet(oldValue,B)) {
//                        System.out.println(Thread.currentThread().getName() + "已经对原始值进行了修改，此时值为：" + ATOMIC_REFERENCE.get());
//                    }
                    System.out.println("===111111==>>>>>");

                    if (ATOMIC_STAMPED_REFERENCE.compareAndSet(oldValue,B,stamp,stamp+1)) {
                        System.out.println(Thread.currentThread().getName() + "已经对原始值：" + oldValue + "进行了修改，此时值为：" + ATOMIC_STAMPED_REFERENCE.getReference());
                    }
                }
            };
            threads[i].start();
        }

        startLatch.countDown();
        Thread.sleep(200);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(RANDOM.nextInt() & 200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String oldVal = ATOMIC_REFERENCE.get();
                int stamp = ATOMIC_STAMPED_REFERENCE.getStamp();
                String oldVal = ATOMIC_STAMPED_REFERENCE.getReference();

//                while(!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.get(),A));
//                System.out.println(Thread.currentThread().getName() + "已经将值" + oldVal + "修改成原始值：" + ATOMIC_REFERENCE.get());
            while (!ATOMIC_STAMPED_REFERENCE.compareAndSet(B,A,stamp,stamp+1)) {
                stamp = ATOMIC_STAMPED_REFERENCE.getStamp();
            }
                System.out.println(Thread.currentThread().getName() + "已经将值" + oldVal + "修改成原始值：A");
            }
        }.start();
    }
}
