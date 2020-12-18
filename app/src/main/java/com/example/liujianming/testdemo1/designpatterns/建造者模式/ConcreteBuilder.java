package com.example.liujianming.testdemo1.designpatterns.建造者模式;

public class ConcreteBuilder extends Builder {
    private Computer mComputer = new Computer();
    @Override
    public void buildCPU(String cpu) {
        mComputer.setmCPU(cpu);
    }

    @Override
    public void buildMemory(String memory) {
        mComputer.setmMemory(memory);
    }

    @Override
    public void buildHD(String hd) {
        mComputer.setmHD(hd);
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
