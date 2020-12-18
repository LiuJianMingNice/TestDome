package com.example.liujianming.testdemo1.test.architect.generic;

import android.os.Build;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionDemo {


    public static void test1() {
        Class<Student> studentClass = Student.class;

        try {
            Student student = ((Student)studentClass.newInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        Class<Student> studentClass = (Student.class);
        Constructor<?>[] constructors = studentClass.getConstructors();

        for (int i = 0; i < constructors.length; i++) {
            System.out.println("Name: " + constructors[i].getName());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                System.out.println("Count: " + constructors[i].getParameterCount());
            }
            System.out.println("Types: " + constructors[i].getParameterTypes());
        }

        try {
            Constructor<Student> constructor = studentClass.getConstructor(String.class,int.class,String.class);
            Student student = constructor.newInstance("hahaha",3,"white");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        Class<Student> studentClass = Student.class;

        Field[] fields = studentClass.getFields();

        Field[] declaredFields = studentClass.getDeclaredFields();

        int len = declaredFields.length;

        for(int i = 0; i< len; i++) {

            int modifiers = declaredFields[i].getModifiers(); //获取每个属性的修饰符，但是这么获取的是修饰符的整数值

            String modifilesName = Modifier.toString(modifiers); //因此可用修饰符的一个类Modifier.toString()方法再转换成字符串

            System.out.println(modifilesName + ", " + declaredFields[i].getType() + ", " + declaredFields[i].getName());
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }
}
