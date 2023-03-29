package com.example.javaprogrammingideas.test;

/**
 * ClassName:DotThis
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-2
 * @author:liujianming
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }
    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }
    public Inner inner() {
        return new Inner();
    }
    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
