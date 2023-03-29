package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

import java.math.BigDecimal;

/**
 * ClassName:NumberFactoryImpl
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns
 *
 * @date:21-5-21
 * @author:liujianming
 */
public class NumberFactoryImpl implements NumberFactory {
    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
