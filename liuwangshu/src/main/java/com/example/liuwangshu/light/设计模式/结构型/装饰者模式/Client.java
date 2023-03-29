package com.example.liuwangshu.light.设计模式.结构型.装饰者模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.结构型.装饰者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {
    public static void main(String[] args) {
        YangGuo yangGuo = new YangGuo();
        HongQiGong hongQiGong = new HongQiGong(yangGuo);
        hongQiGong.attackMagic();
        OuYangFeng ouYangFeng = new OuYangFeng(yangGuo);
        ouYangFeng.attackMagic();
    }
}
