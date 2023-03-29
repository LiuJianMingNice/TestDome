package com.example.javaprogrammingideas.test;

/**
 * ClassName:Outer
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
public class Outer {

    static final int a = 3;
    static int b = 5;
    String c;
    double d;

    public class Inner {

    }

    //静态方法不能访问非静态成员
//    public static Inner getInner1() {
//        return new Inner();
//    }

    public Inner getInner2() {
        return new Inner();
    }
}
