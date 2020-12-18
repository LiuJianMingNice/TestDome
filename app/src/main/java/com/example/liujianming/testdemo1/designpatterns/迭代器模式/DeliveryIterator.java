package com.example.liujianming.testdemo1.designpatterns.迭代器模式;

public class DeliveryIterator implements Iterator {

    private Aggregate mAggregate;
    private int index;

    public DeliveryIterator(Aggregate mAggregate) {
        this.mAggregate = mAggregate;
    }

    @Override
    public boolean hasNext() {

        if (index < mAggregate.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        return mAggregate.get(index++);
    }
}
