package com.example.liuwangshu.light.设计模式.结构型.享元模式;

/**
 * ClassName:Goods
 * Package:com.example.liuwangshu.light.设计模式.结构型.享元模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Goods implements IGoods {
    private String name;
    private String version;
    Goods(String name) {
        this.name = name;
    }
    @Override
    public void showGoodsPrice(String version) {
        if (version.equals("32G")) {
            System.out.println("价格为5199");
        } else if (version.equals("128G")) {
            System.out.println("价格为5999");
        }
    }
}
