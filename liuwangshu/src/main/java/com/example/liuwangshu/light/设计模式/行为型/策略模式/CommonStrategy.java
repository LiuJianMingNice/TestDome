package com.example.liuwangshu.light.设计模式.行为型.策略模式;

/**
 * ClassName:CommonStrategy
 * Package:com.example.liuwangshu.light.设计模式.行为型.策略模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class CommonStrategy implements FightingStrategy {
    @Override
    public void fighting() {
        System.out.println("遇到普通对手，张无忌使用圣火令神功");
    }
}
