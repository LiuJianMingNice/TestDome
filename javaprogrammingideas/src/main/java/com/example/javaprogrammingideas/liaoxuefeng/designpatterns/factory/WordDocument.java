package com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory;

import android.graphics.Path;

import java.io.IOException;

/**
 * ClassName:WordDocument
 * Package:com.example.javaprogrammingideas.liaoxuefeng.designpatterns.factory
 *
 * @date:21-5-21
 * @author:liujianming
 */
public interface WordDocument {
    void save(Path path) throws IOException;
}
