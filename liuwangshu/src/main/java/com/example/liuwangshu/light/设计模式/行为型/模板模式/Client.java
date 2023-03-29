package com.example.liuwangshu.light.设计模式.行为型.模板模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.行为型.模板模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {
    public static void main(String[] args) {
        ZhangWuJi zhangWuJi = new ZhangWuJi();
        zhangWuJi.fighting();
        ZhangSanFeng zhangSanFeng = new ZhangSanFeng();
        zhangSanFeng.fighting();
    }
}
