package com.example.liujianming.testdemo1.designpatterns.抽象工厂模式;

public class HuaWeiComputerFactory extends ComputerFactory {
    @Override
    public CPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public Memory createMemory() {
        return new SamsungMemory();
    }

    @Override
    public HD createHD() {
        return new SeagateHD();
    }
}
