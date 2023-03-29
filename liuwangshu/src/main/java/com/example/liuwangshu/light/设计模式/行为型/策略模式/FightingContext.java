package com.example.liuwangshu.light.设计模式.行为型.策略模式;

/**
 * ClassName:FightingContext
 * Package:com.example.liuwangshu.light.设计模式.行为型.策略模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class FightingContext {
    private FightingStrategy fightingStrategy;
    FightingContext(FightingStrategy fightingStrategy) {
       this.fightingStrategy = fightingStrategy;
    }

    public void fighting() {
        fightingStrategy.fighting();
    }
}
