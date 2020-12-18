package com.example.liujianming.testdemo1.掘金demo.ljm.thread;

public class ProducerConsumer {

    public static void main(String[] args) {
        Info info = new Info();
        Producer producer = new Producer(info);
        Consumer consumer = new Consumer(info);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Consumer implements Runnable{

    private Info info;
    public Consumer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            info.consumer();
        }
    }
}

class Producer implements Runnable{

    private Info info;
    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            info.producer("小" + i, i);
        }
    }
}

class Info{
    private String name;
    private int age;
    private boolean isProducer = true;
    public synchronized void producer(String name, int age) {
        while (!isProducer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setAge(age);
        setName(name);
        System.out.println("productor create one info");
        isProducer = false;
        notify();
    }

    public synchronized void consumer() {
        while (isProducer) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("consumer wait interrupted");
            }
        }
        System.out.println("consumer get " + getName() + ",age is " + getAge());
        isProducer = true;
        notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
