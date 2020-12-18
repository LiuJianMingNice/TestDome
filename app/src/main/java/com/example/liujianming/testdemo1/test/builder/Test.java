package com.example.liujianming.testdemo1.test.builder;

public class Test {

    public static void main(String[] args) {
        CreatComputer();
    }

    public static void CreatComputer() {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.Construct("i7-6700","三星DDR4","希捷１T");
    }
}
