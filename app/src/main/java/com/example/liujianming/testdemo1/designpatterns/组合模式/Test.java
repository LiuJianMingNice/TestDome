package com.example.liujianming.testdemo1.designpatterns.组合模式;

public class Test {
    public static void main(String[] args) {
        PageElement root = new Column("网站页面");
        PageElement music = new Column("音乐");
        PageElement video = new Column("视屏");
        PageElement ad = new Column("广告");
        root.addPageElement(music);
        root.addPageElement(video);
        root.addPageElement(ad);

        PageElement chineseMusic = new Column("国语");
        PageElement cantonMusic = new Column("粤语");
        music.addPageElement(chineseMusic);
        music.addPageElement(cantonMusic);

        chineseMusic.addPageElement(new Content("十年.mp3"));
        chineseMusic.addPageElement(new Content("明年今日.mp3"));

        video.addPageElement(new Content("唐伯虎点秋香.avi"));

        root.print("");
    }
}
