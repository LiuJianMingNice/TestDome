package com.example.liuwangshu.light.设计模式.行为型.观察者模式;

/**
 * ClassName:WeixinUser
 * Package:com.example.liuwangshu.light.设计模式.行为型.观察者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class WeixinUser implements Observer {
    private String name;
    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
