package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

import android.graphics.Path;

import java.io.IOException;

/**
 * ClassName:FastHtmlDocument
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory
 *
 * @date:21-5-21
 * @author:liujianming
 */
public class FastHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return null;
    }

    @Override
    public void save(Path path) throws IOException {

    }

    public FastHtmlDocument(String md) {

    }
}
