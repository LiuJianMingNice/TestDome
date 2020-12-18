package com.example.liujianming.testdemo1.designpatterns.访问者模式;

public class Busy implements Visitor {

    private String name;

    public Busy(String name) {
        this.name = name;
    }

    @Override
    public void visit(Music music) {
        System.out.println(name + "浏览音乐网站" + music.getName());
        music.download();
    }

    @Override
    public void visit(Video video) {
        System.out.println(name + "浏览视频网站" + video.getName());
        video.download();
    }
}
