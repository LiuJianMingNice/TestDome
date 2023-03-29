package com.example.jianshuprojection.test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        //getAndIncrement返回的是自增前的值
        int beforeValue = ai.getAndIncrement();
        //输出自增前的值
        System.out.println("自增前的值：" + beforeValue);
        //输出自增后的值
        System.out.println("自增后的值：" + ai);

        //incrementAndGet返回的是自增后的值
        int afterValue = ai.incrementAndGet();
        //输出11
        System.out.println("afterValue:" + afterValue);

        //addAndGet增加指定的值并返回增加后的值
        System.out.println(ai.addAndGet(100));

        //getAndAdd增加指定的值并返回增加前的值
        System.out.println(ai.getAndAdd(100));

        //ai的值是否符合期望值，符合则修改为200，并返回true
        System.out.println(ai.compareAndSet(1,200));
        System.out.println(ai);
    }
}
