package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.time.Month;

/**
 * ClassName:TestReflection
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-10
 * @author:liujianming
 */
public class TestReflection {
    public static void main(String[] args) throws Exception {
//        testClassInfo();
        testGetField();
    }

    private static void testClassInfo() {
        printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            printClassInfo(Month.class);
        }
        printClassInfo(String[].class);
        printClassInfo(int.class);
    }

    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
    }

    private static void testGetField() throws Exception {
        Class stdClass = Student2.class;
        System.out.println(stdClass.getField("score"));
        System.out.println(stdClass.getField("name"));
        System.out.println(stdClass.getDeclaredField("grade"));
        System.out.println(stdClass.getMethod("getScore", String.class));
        System.out.println(stdClass.getMethod("getName"));
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));
    }
}

class Student2 extends Person2 {
    public int score;
    private int grade;

    public int getScore(String type) {
        return 99;
    }

    private int getGrade(int year) {
        return 1;
    }
}

class Person2 {
    public String name;

    public String getName() {
        return "Person";
    }
}
