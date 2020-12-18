package com.example.liujianming.testdemo1.designpatterns.访问者模式;

public class Video extends Web {

    public Video(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void download() {
        System.out.println("下载视频");
    }

    public void playVideo() {
        System.out.println("播放视频");
    }
}
