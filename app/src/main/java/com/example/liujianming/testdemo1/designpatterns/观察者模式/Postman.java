package com.example.liujianming.testdemo1.designpatterns.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Postman implements Observable {

    private List<Observer> personList = new ArrayList<Observer>();
    @Override
    public void add(Observer observer) {
        personList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        personList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : personList) {
            observer.update(message);
        }
    }
}
