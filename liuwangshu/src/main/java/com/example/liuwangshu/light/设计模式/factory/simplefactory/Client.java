package com.example.liuwangshu.light.设计模式.factory.simplefactory;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.factory
 *
 * @date:21-6-2
 * @author:liujianming
 */
public class Client {
    public static void main(String[] args ){
        CreateFactory.createComputer("hp").start();
    }
}
