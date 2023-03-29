package com.example.liuwangshu.light.设计模式.行为型.模板模式;

/**
 * ClassName:AbstractSwordsman
 * Package:com.example.liuwangshu.light.设计模式.行为型.模板模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public abstract class AbstractSwordsman {
    public final void fighting() {
        neigong();
        meridian();
        if (hasWeapons()) {
            weapons();
        }
        moves();
        hook();
    }
    protected void hook(){}
    protected abstract void neigong();
    protected abstract void weapons();
    protected abstract void moves();
    protected void meridian() {
        System.out.println("开启正经与奇经");
    }
    protected boolean hasWeapons() {
        return true;
    }
}
