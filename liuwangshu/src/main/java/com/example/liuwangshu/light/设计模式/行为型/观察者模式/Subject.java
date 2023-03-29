package com.example.liuwangshu.light.设计模式.行为型.观察者模式;

/**
 * ClassName:Subject
 * Package:com.example.liuwangshu.light.设计模式.行为型.观察者模式
 *
 * @date:21-6-3
 * @author:liujianming
 */
public interface Subject {
    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notify(String message);
}
