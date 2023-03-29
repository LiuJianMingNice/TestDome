package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

import android.graphics.Path;

import java.io.IOException;

/**
 * ClassName:HtmlDocument
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory
 *
 * @date:21-5-21
 * @author:liujianming
 */
public interface HtmlDocument {
    String toHtml();
    void save(Path path) throws IOException;
}
