package com.example.javaprogrammingideas.test;

/**
 * ClassName:NewOuter
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
public class NewOuter {
    int a = 1;
    static int b = 2;

    public class InnerClass {
        int a = 3;
        static final int b = 4;

        public void run() {
            //内部类引用this
            System.out.println("a = " + this.a);
            System.out.println("b = " + b);
            //外部类引用this
            System.out.println("NewOuterTest.this.a = " + NewOuter.this.a);
            System.out.println("NewOuterTest.b = " + NewOuter.b);
            System.out.println("NewOuterTest.this.b = " + NewOuter.this.b);
        }
    }

    public static void main(String[] args) {
        NewOuter outer = new NewOuter();
        NewOuter.InnerClass innerClass = outer.new InnerClass();
        innerClass.run();
    }
}
