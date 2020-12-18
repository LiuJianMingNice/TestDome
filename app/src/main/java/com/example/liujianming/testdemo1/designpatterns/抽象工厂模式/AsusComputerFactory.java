package com.example.liujianming.testdemo1.designpatterns.抽象工厂模式;

public class AsusComputerFactory extends ComputerFactory {
    @Override
    public CPU createCPU() {
        return new AmdCPU();
    }

    @Override
    public Memory createMemory() {
        return new KingstonMemory();
    }

    @Override
    public HD createHD() {
        return new WdHD();
    }
}
