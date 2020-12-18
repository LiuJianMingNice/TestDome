package com.example.liujianming.testdemo1.designpatterns.中介者模式;

public class Lianjia implements HouseMediator {
    Purchaser mPurchaser;
    Landlord mLandlord;

    public void setPurchaser(Purchaser purchaser) {
        mPurchaser = purchaser;
    }

    public void setLandlord(Landlord landlord) {
        mLandlord = landlord;
    }
    @Override
    public void notice(Person person, String msg) {
        System.out.println("中介收到消息，并转发给相应的目标人群");
        if (person == mPurchaser) {
            mLandlord.getNotice(msg);
        } else if (person == mLandlord) {
            mPurchaser.getNotice(msg);
        }
    }
}
