package com.example.liujianming.testdemo1.designpatterns.备忘录模式;

public class Game {
    private int mLevel = 1;
    private int mCoin = 0;

    @Override
    public String toString() {
        return "Game{" +
                "mLevel=" + mLevel +
                ", mCoin=" + mCoin +
                '}';
    }

    public void play() {
        System.out.println("升级了");
        mLevel++;
        System.out.println("当前等级为：" + mLevel);
        System.out.println("获得金币：32");
        mCoin += 32;
        System.out.println("当前金币数量为：" + mCoin);
    }

    public void exit() {
        System.out.println("退出游戏");
        System.out.println("退出游戏是的属性：" + toString());
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        memento.setLevel(mLevel);
        memento.setCoin(mCoin);
        return memento;
    }

    public void setMemento(Memento memento) {
        mLevel = memento.getLevel();
        mCoin = memento.getCoin();
        System.out.println("获取存档信息：" + toString());
    }
}
