package com.example.liujianming.testdemo1.掘金demo.ljm.demo;

import java.lang.ref.Reference;

public class Student extends Person {

    public static String identity = "Student";

    static {
        System.out.println("I'am a student");
    }

    public Student() {
        System.out.println("初始化Student");
    }
}
