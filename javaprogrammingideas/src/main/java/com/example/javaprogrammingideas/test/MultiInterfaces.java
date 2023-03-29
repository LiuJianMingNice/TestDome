package com.example.javaprogrammingideas.test;

/**
 * ClassName:MultiInterfaces
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
interface A {
    void run();
}
interface B {
    void fly();
}
class X implements A, B {
    @Override
    public void run() {

    }

    @Override
    public void fly() {

    }
}
class Y implements A {

    B makeB() {
        return new B() {
            @Override
            public void fly() {

            }
        };
    }

    @Override
    public void run() {

    }
}
public class MultiInterfaces {
    static void takesA(A a) {}

    static void takesB(B b) {}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
