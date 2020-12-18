package com.example.liujianming.testdemo1.designpatterns.观察者模式;

public interface Observable {

    void add(Observer observer);
    void remove(Observer observer);
    void notify(String message);
}
