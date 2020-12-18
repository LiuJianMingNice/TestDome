package com.example.liujianming.testdemo1.designpatterns.建造者模式;

public abstract class Builder {
    public abstract void buildCPU(String cpu);
    public abstract void buildMemory(String momery);
    public abstract void buildHD(String hd);
    public abstract Computer create();
}
