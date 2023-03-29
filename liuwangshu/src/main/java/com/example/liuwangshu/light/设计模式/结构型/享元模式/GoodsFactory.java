package com.example.liuwangshu.light.设计模式.结构型.享元模式;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:GoodsFactory
 * Package:com.example.liuwangshu.light.设计模式.结构型.享元模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class GoodsFactory {
    private static Map<String, Goods> pool = new HashMap<String, Goods>();
    public static Goods getGoods(String name) {
        if (pool.containsKey(name)) {
            System.out.println("使用缓存key为： " + name);
            return pool.get(name);
        } else {
            Goods goods = new Goods(name);
            pool.put(name, goods);
            System.out.println("创建商品，key为： " + name);
            return goods;
        }
    }
}
