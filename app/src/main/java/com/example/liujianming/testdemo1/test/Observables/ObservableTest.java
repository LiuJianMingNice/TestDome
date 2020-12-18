package com.example.liujianming.testdemo1.test.Observables;

public interface ObservableTest {

    void add(ObserverTest observer);

    void remove(ObserverTest observer);

    void notify(String message);
}
