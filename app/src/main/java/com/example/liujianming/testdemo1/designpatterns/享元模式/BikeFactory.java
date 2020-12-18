package com.example.liujianming.testdemo1.designpatterns.享元模式;

import java.util.HashMap;
import java.util.Map;

public class BikeFactory {
    private static Map<String, IBike> pool = new HashMap<>();

    public IBike getBike(String name) {
        IBike bike = null;
        if (pool.containsKey(name)) {
            System.out.println("押金已交，直接用车：" + name);
            bike = pool.get(name);
        } else {
            bike = new ShareBike();
            pool.put(name,bike);
            System.out.println(name + "交100押金，可以用车了");
        }
        return bike;
    }
}
