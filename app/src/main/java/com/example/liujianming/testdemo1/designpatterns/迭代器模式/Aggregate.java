package com.example.liujianming.testdemo1.designpatterns.迭代器模式;

public interface Aggregate {

    int size();
    String get(int location);
    void add(String tel);
    void remove(String tel);
    Iterator iterator();
}
