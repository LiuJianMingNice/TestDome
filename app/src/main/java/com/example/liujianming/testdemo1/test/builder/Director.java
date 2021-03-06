package com.example.liujianming.testdemo1.test.builder;

public class Director {

    private Builder mBuild = null;

    public Director(Builder builder) {
        this.mBuild = builder;
    }

    public void Construct(String cpu,String memory,String hd) {
        mBuild.buildCPU(cpu);
        mBuild.buildMemory(memory);
        mBuild.buildHD(hd);
    }
}
