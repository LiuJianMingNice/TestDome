package com.example.liuwangshu.light.设计模式.行为型.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:SubscriptionSubject
 * Package:com.example.liuwangshu.light.设计模式.行为型.观察者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class SubscriptionSubject implements Subject {
    private List<Observer> weixinUserList = new ArrayList<Observer>();
    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
