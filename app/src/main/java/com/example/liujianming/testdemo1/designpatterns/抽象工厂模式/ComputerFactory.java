package com.example.liujianming.testdemo1.designpatterns.抽象工厂模式;

public abstract class ComputerFactory {

    public abstract CPU createCPU();

    public abstract Memory createMemory();

    public abstract HD createHD();
}
