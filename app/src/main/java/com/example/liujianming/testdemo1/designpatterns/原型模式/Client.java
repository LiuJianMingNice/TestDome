package com.example.liujianming.testdemo1.designpatterns.原型模式;

public class Client {

    public void test() throws CloneNotSupportedException {
        Card card1 = new Card();
        card1.setNum(9527);
        card1.setSpec(10, 20);
        System.out.println(card1.toString());
        System.out.println("-------------");

        Card card2 = card1.clone();
        System.out.println(card2.toString());
        System.out.println("-------------");

        card2.setNum(7259);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println("-------------");

        card2.setSpec(30, 40);
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println("-------------");
    }
}
