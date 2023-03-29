package com.example.liuwangshu.light.设计模式.结构型.代理模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.结构型.代理模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {

    public static void main(String[] args) {
        IShop liuJianMing = new LiuJianMing();
        IShop purchasing = new Purchasing(liuJianMing);
        purchasing.buy();
    }
}
