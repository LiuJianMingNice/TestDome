package com.example.liujianming.testdemo1.designpatterns.访问者模式;

public class Music extends Web {

    public Music(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void download() {
        System.out.println("下载音乐");
    }

    public void playMusic() {
        System.out.println("播放音乐");
    }
}
