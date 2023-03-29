package com.example.javaprogrammingideas.test;

/**
 * ClassName:Enclosing
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
public class Enclosing {
    private static int x = 1;
    public static class StaticNested {
        private void run() {
            System.out.println("en......");
        }
    }


    public void test() {
        Enclosing.StaticNested nested = new Enclosing.StaticNested();
        nested.run();
    }

    public static void main(String[] args) {
        Enclosing.StaticNested nested = new Enclosing.StaticNested();
        nested.run();
    }
}
