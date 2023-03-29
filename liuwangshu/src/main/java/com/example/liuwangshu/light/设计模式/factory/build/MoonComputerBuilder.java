package com.example.liuwangshu.light.设计模式.factory.build;

/**
 * ClassName:MoonComputerBuilder
 * Package:com.example.liuwangshu.light.factory.build
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class MoonComputerBuilder extends Builder {

    private Computer mComputer = new Computer();

    @Override
    public void buildCpu(String cpu) {
        mComputer.setCpu(cpu);
    }

    @Override
    public void buildMainBoard(String mainBoard) {
        mComputer.setMainBoard(mainBoard);
    }

    @Override
    public void buildRam(String ram) {
        mComputer.setRam(ram);
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
