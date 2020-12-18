package com.example.liujianming.testdemo1.designpatterns.备忘录模式;

public class Memento {
    public int level;
    public int coin;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}
