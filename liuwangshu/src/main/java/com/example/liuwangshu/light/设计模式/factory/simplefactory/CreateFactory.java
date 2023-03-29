package com.example.liuwangshu.light.设计模式.factory.simplefactory;

/**
 * ClassName:CreateFactory
 * Package:com.example.liuwangshu.light.factory
 *
 * @date:21-6-2
 * @author:liujianming
 */
public class CreateFactory {
    public static Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "hp":
                computer = new HPComputer();
                break;
            case "xiaomi":
                computer = new XiaoMiComputer();
                break;
        }
        return computer;
    }
}
