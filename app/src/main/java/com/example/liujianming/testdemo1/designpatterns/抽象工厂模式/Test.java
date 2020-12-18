package com.example.liujianming.testdemo1.designpatterns.抽象工厂模式;

public class Test {
    public static void main(String[] args) {
        System.out.println("----生产华为电脑-----");
        ComputerFactory huaweiComputerFactory = new HuaWeiComputerFactory();
        huaweiComputerFactory.createCPU().showCPU();
        huaweiComputerFactory.createMemory().showMemory();
        huaweiComputerFactory.createHD().showHD();
        System.out.println("----生产华硕电脑-----");
        ComputerFactory asusComputerFactory = new AsusComputerFactory();
        asusComputerFactory.createCPU().showCPU();
        asusComputerFactory.createMemory().showMemory();
        asusComputerFactory.createHD().showHD();
    }
}
