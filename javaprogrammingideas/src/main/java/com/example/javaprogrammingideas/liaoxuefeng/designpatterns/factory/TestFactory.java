package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

/**
 * ClassName:TestFactory
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory
 *
 * @date:21-5-21
 * @author:liujianming
 */
public class TestFactory {
    public static void main(String[] args) {
        NumberFactory factory = NumberFactory.getFactory();
        Number result = factory.parse("123.456");
        System.out.println("result===>>> " + result.doubleValue());
    }
}
