package com.example.liuwangshu.light.设计模式.factory.build;

/**
 * ClassName:Computer
 * Package:com.example.liuwangshu.light.factory.build
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Computer {
    private String mCpu;
    private String mMainBoard;
    private String mRam;

    public void setCpu(String mCpu) {
        this.mCpu = mCpu;
    }

    public void setMainBoard(String mMainBoard) {
        this.mMainBoard = mMainBoard;
    }

    public void setRam(String mRam) {
        this.mRam = mRam;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mCpu='" + mCpu + '\'' +
                ", mMainBoard='" + mMainBoard + '\'' +
                ", mRam='" + mRam + '\'' +
                '}';
    }
}
