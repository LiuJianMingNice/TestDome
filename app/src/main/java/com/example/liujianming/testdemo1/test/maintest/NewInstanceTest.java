package com.example.liujianming.testdemo1.test.maintest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class NewInstanceTest {
    public static void main(String[] args) throws IllegalAccessException,InstantiationException,NoSuchMethodException, InvocationTargetException {
        Class c = Date.class;
        Date date1 = (Date) c.newInstance();
        System.out.println(date1);

        long timestamp = date1.getTime();
        Constructor constructor = c.getConstructor(long.class);
        Date date2 = (Date) constructor.newInstance(timestamp);
        System.out.println(date2);
    }
}
