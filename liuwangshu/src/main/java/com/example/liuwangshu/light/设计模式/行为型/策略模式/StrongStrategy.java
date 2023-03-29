package com.example.liuwangshu.light.设计模式.行为型.策略模式;

/**
 * ClassName:StrongStrategy
 * Package:com.example.liuwangshu.light.设计模式.行为型.策略模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class StrongStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        System.out.println("遇到强大的对手，张无忌使用乾坤大挪移");
    }
}
