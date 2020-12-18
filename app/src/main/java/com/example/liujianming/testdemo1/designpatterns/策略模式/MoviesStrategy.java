package com.example.liujianming.testdemo1.designpatterns.策略模式;

public class MoviesStrategy implements ChaseStragety {
    @Override
    public void chase() {
        System.out.println("一起看电影");
    }
}
