package com.example.liuwangshu.light.test;

import java.util.PriorityQueue;

/**
 * ClassName:TestBlockingQueue
 * Package:com.example.liuwangshu.light.test
 *
 * @date:21-5-29
 * @author:liujianming
 */
public class TestBlockingQueue {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);
    public static void main(String[] args) {
        TestBlockingQueue testBlockingQueue = new TestBlockingQueue();
        Producer producer = testBlockingQueue.new Producer();
        Consumer consumer = testBlockingQueue.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);
                    queue.notify();
                }
            }
        }
    }
}
