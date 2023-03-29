package com.example.liuwangshu.light.设计模式.行为型.策略模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.行为型.策略模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {

    public static void main(String[] args) {
        FightingContext fightingContext;
        fightingContext = new FightingContext(new WeakRivalStrategy());
        fightingContext.fighting();
        fightingContext = new FightingContext(new CommonStrategy());
        fightingContext.fighting();
        fightingContext = new FightingContext(new StrongStrategy());
        fightingContext.fighting();
    }
}
