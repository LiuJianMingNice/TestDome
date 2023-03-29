package com.example.javaprogrammingideas.test;

/**
 * ClassName:CallBacks
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
interface IncrementAble {
    void increment();
}
class Callee1 implements IncrementAble {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println("Callee1 i = " + i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi) {
        mi.increment();
    }
}
class Callee2 extends MyIncrement {
    private int i = 0;

    @Override
    public void increment() {
        super.increment();
        i++;
        System.out.println("Callee2 i = " + i);
    }
    private class Closure implements IncrementAble {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    IncrementAble getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private IncrementAble callbackReference;
    Caller(IncrementAble cbh) {
        callbackReference = cbh;
    }
    void go() {
        callbackReference.increment();
    }
}
public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
