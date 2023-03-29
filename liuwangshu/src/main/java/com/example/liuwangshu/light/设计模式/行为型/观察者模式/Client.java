package com.example.liuwangshu.light.设计模式.行为型.观察者模式;

/**
 * ClassName:Client
 * Package:com.example.liuwangshu.light.设计模式.行为型.观察者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public class Client {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        WeixinUser user1 = new WeixinUser("Bob");
        WeixinUser user2 = new WeixinUser("Mike");
        WeixinUser user3 = new WeixinUser("Ben");

        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);

        mSubscriptionSubject.notify("刘望舒的专栏更新了");
    }
}
