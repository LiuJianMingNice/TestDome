package com.example.liujianming.testdemo1.designpatterns.迭代器模式;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAggregate implements Aggregate {

    List<String> mList = new ArrayList<>();

    @Override
    public int size() {
        return mList.size();
    }

    @Override
    public String get(int location) {
        return mList.get(location);
    }

    @Override
    public void add(String tel) {
        mList.add(tel);
    }

    @Override
    public void remove(String tel) {
        mList.remove(tel);
    }

    @Override
    public Iterator iterator() {
        return new DeliveryIterator(this);
    }
}
