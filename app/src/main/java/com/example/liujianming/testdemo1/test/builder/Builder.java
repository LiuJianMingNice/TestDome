package com.example.liujianming.testdemo1.test.builder;

public abstract class Builder {
    public abstract void buildCPU(String cpu);

    public abstract void buildMemory(String memory);

    public abstract void buildHD(String hd);

    public abstract Computer create();
}
