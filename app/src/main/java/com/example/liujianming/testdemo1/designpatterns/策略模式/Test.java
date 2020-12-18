package com.example.liujianming.testdemo1.designpatterns.策略模式;

public class Test {
    public static void main(String[] args) {
        Context context;
        System.out.println("遇到爱逛街的女孩子");
        context = new Context(new ShoppingStrategy());
        context.chase();
        System.out.println("遇到爱看电影的女孩子");
        context = new Context(new MoviesStrategy());
        context.chase();
        System.out.println("遇到爱吃的女孩子");
        context = new Context(new EattingStrategy());
        context.chase();
    }
}
