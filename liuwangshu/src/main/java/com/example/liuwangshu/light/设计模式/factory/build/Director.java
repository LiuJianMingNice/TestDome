package com.example.liuwangshu.light.设计模式.factory.build;

/**
 * ClassName:Direcror
 * Package:com.example.liuwangshu.light.factory.build
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder builder) {
        this.mBuilder = builder;
    }

    public Computer createComputer(String cpu, String mainBoard, String ram) {
        this.mBuilder.buildCpu(cpu);
        this.mBuilder.buildMainBoard(mainBoard);
        this.mBuilder.buildRam(ram);
        return mBuilder.create();
    }
}
