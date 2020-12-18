package com.example.liujianming.testdemo1.test.builder;

public class ConcreteBuilder extends Builder {

    private Computer mComputer = new Computer();

    @Override
    public void buildCPU(String cpu) {
        mComputer.setCPU(cpu);
    }

    @Override
    public void buildMemory(String memory) {
        mComputer.setMemory(memory);
    }

    @Override
    public void buildHD(String hd) {
        mComputer.setHD(hd);
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
