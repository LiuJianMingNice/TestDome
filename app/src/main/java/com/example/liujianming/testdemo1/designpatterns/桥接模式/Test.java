package com.example.liujianming.testdemo1.designpatterns.桥接模式;

public class Test {
    public static void main(String[] args) {
        Clothes uniform = new Uniform();
        Clothes shirt = new Shirt();

        Person coder = new Coder();
        coder.setClothes(shirt);
        coder.dress();
        System.out.println("----------------");
        Person student = new Student();
        student.setClothes(uniform);
        student.dress();
        System.out.println("----------------");
        student.setClothes(shirt);
        student.dress();
    }
}
