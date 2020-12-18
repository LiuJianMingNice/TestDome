package com.example.liujianming.testdemo1.designpatterns.适配器模式;

public class ForeignCenter {
    private String name;
    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void 进攻() {
        System.out.println("外籍中锋" + Name + "进攻");
    }

    public void 防守() {
        System.out.println("外籍中锋" + Name + "防守");
    }
}
