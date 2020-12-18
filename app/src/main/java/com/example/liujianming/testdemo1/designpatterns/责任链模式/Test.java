package com.example.liujianming.testdemo1.designpatterns.责任链模式;

public class Test {
    public static void main(String[] args) {
        Postman beijingPostman = new BeijingPostman();
        Postman shanghaiPostman = new ShanghaiPostman();
        Postman guangzhouPostman = new GuangzhouPostman();

        beijingPostman.nextPosman = shanghaiPostman;
        shanghaiPostman.nextPosman = guangzhouPostman;

        System.out.println("有一个快递需要送到上海");
        beijingPostman.handleCourier("Shanghai");
        System.out.println("有一个快递需要送到广州");
        beijingPostman.handleCourier("Guangzhou");
        System.out.println("有一个快递需要送到美国");
        beijingPostman.handleCourier("America");
    }
}
