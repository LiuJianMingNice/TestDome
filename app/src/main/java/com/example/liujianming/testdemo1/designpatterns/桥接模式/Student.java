package com.example.liujianming.testdemo1.designpatterns.桥接模式;

import com.example.liujianming.testdemo1.designpatterns.组合模式.PageElement;

public class Student extends Person {
    @Override
    protected void dress() {
        System.out.println("学生穿上" + mClothes.getName());
    }
}
