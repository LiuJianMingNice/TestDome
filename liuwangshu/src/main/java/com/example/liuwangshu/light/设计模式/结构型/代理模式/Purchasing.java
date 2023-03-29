package com.example.liuwangshu.light.设计模式.结构型.代理模式;

/**
 * ClassName:Purchasing
 * Package:com.example.liuwangshu.light.设计模式.结构型.代理模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Purchasing implements IShop {
    private IShop mIShop;
    public Purchasing(IShop iShop) {
        this.mIShop = iShop;
    }
    @Override
    public void buy() {
        mIShop.buy();
    }
}
