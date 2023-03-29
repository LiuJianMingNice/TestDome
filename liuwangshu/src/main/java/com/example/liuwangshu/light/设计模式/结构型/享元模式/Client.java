package com.example.liuwangshu.light.设计模式.结构型.享元模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.结构型.享元模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {
    public static void main(String[] args) {
        Goods goods1 = GoodsFactory.getGoods("iPone 7");
        goods1.showGoodsPrice("32G");
        Goods goods2 = GoodsFactory.getGoods("iPone 7");
        goods2.showGoodsPrice("32G");
        Goods goods3 = GoodsFactory.getGoods("iPone 7");
        goods3.showGoodsPrice("128G");
    }
}
