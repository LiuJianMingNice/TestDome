package com.example.liujianming.testdemo1.test.Observables;

import java.util.ArrayList;
import java.util.List;

public class Postman implements ObservableTest {

    private List<ObserverTest> personList = new ArrayList<ObserverTest>();


    @Override
    public void add(ObserverTest observer) {
        personList.add(observer);
    }

    @Override
    public void remove(ObserverTest observer) {
        personList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for(ObserverTest observer : personList) {
            observer.update(message);
        }
    }
}
