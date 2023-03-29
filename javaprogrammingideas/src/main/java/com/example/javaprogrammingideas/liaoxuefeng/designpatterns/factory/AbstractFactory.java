package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

/**
 * ClassName:AbstaractFactory
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory
 *
 * @date:21-5-21
 * @author:liujianming
 */
public interface AbstractFactory {
        HtmlDocument createHtml(String md);
        WordDocument createWord(String md);
}
