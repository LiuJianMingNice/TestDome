package com.example.liujianming.testdemo1.designpatterns.原型模式;

public class Spec implements Cloneable {
    private int width;
    private int length;

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Spec{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    @Override
    protected Spec clone() throws CloneNotSupportedException {
        return (Spec) super.clone();
    }
}
