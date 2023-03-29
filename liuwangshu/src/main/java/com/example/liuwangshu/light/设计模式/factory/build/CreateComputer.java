package com.example.liuwangshu.light.设计模式.factory.build;

/**
 * ClassName:CraeteComputer
 * Package:com.example.liuwangshu.light.factory.build
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class CreateComputer {
    public static void main(String[] args) {
        Builder builder = new MoonComputerBuilder();
        Director director = new Director(builder);
        Computer computer = director.createComputer("i7", "华擎至尊玩家", "三星DDR4");
        System.out.println(computer.toString());
    }
}
