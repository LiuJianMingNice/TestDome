package com.example.liujianming.testdemo1.designpatterns.建造者模式;

public class Computer {
    private String mCPU;
    private String mMemory;
    private String mHD;

    public String getmCPU() {
        return mCPU;
    }

    public void setmCPU(String mCPU) {
        this.mCPU = mCPU;
    }

    public String getmMemory() {
        return mMemory;
    }

    public void setmMemory(String mMemory) {
        this.mMemory = mMemory;
    }

    public String getmHD() {
        return mHD;
    }

    public void setmHD(String mHD) {
        this.mHD = mHD;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "mCPU='" + mCPU + '\'' +
                ", mMemory='" + mMemory + '\'' +
                ", mHD='" + mHD + '\'' +
                '}';
    }
}
