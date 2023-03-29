package com.example.javaprogrammingideas.test;

/**
 * ClassName:Event
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }
    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }
    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }
    public abstract void action();
}
