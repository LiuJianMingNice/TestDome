package com.example.liujianming.testdemo1.掘金demo.ljm.demo;

public class Singleton {

    private static Singleton singleton = new Singleton();

    public static int x = 0;
    public static int y = 0;

    public Singleton() {
        ++x;
        ++y;
        System.out.println("x==>>> " + x + "y==>>> " + y);
    }

    public static void main(String[] args) {
        System.out.println("singleton.x===>>> " + singleton.x);
        System.out.println("singleton.y===>>> " + singleton.y);
    }
}
