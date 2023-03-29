package com.example.liujianming.testdemo1.test.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 126;
        Integer i4 = 126;

        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }
}
