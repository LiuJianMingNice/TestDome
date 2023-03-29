package com.example.liuwangshu.light.设计模式.结构型.装饰者模式;

/**
 * ClassName:OuYangFeng
 * Package:com.example.liuwangshu.light.设计模式.结构型.装饰者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class OuYangFeng extends Master {

    public OuYangFeng(Swordsman swordsman) {
        super(swordsman);
    }

    private void teachAttackMagic() {
        System.out.println("欧阳锋教杨过使用蛤蟆功");
        System.out.println("杨过使用蛤蟆功");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
