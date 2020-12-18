package com.example.liujianming.testdemo1.designpatterns.访问者模式;

public class Test {
    public static void main(String[] args) {
        Web wangyiyun = new Music("网易云");
        Web kugou = new Music("酷狗");
        Web aiqiyi = new Video("爱奇艺");
        Web youku = new Video("优酷");

        Websites websites = new Websites();
        websites.addWeb(wangyiyun);
        websites.addWeb(kugou);
        websites.addWeb(aiqiyi);
        websites.addWeb(youku);

        Visitor idler1 = new Idler("闲人一号");
        websites.accept(idler1);
        System.out.println("-------------------");
        Visitor busy1 = new Busy("忙人一号");
        websites.accept(busy1);
    }
}
