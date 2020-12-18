package com.example.liujianming.testdemo1.designpatterns.迭代器模式;

public class Test {

    public static void main(String[] args) {
        Aggregate aggregate = new DeliveryAggregate();
        aggregate.add("11111");
        aggregate.add("22222");
        aggregate.add("33333");
        aggregate.add("44444");
        aggregate.add("95722");

        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            String tel = (String) iterator.next();
            System.out.println("当前号码为：" + tel);
        }
        System.out.println("后面没了");
    }
}
