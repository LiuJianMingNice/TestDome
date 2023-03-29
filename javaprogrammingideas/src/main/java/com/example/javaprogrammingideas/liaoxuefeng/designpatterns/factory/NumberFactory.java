package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

/**
 * ClassName:NumberFactory
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns
 *
 * @date:21-5-21
 * @author:liujianming
 */
public interface NumberFactory {
    Number parse(String s);
    static NumberFactory getFactory() {
        return impl;
    }
    static NumberFactory impl = new NumberFactoryImpl();
}
