package com.example.liuwangshu.light.设计模式.结构型.装饰者模式;

import java.util.regex.Matcher;

/**
 * ClassName:Master
 * Package:com.example.liuwangshu.light.设计模式.结构型.装饰者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Master extends Swordsman {
    private Swordsman mSwordsman;
    public Master(Swordsman swordsman) {
        this.mSwordsman = swordsman;
    }
    @Override
    public void attackMagic() {
        mSwordsman.attackMagic();
    }
}
