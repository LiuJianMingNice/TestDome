package com.example.liujianming.testdemo1.designpatterns.模板方法模式;

public class Test {

    public static void main(String[] args) {
        System.out.println("===派送A===");
        PostA postA = new PostA();
        postA.post();
        System.out.println("===派送B===");
        PostB postB = new PostB();
        postB.post();
    }
}
