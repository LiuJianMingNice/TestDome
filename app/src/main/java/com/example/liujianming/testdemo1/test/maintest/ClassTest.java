package com.example.liujianming.testdemo1.test.maintest;

import com.example.liujianming.testdemo1.test.bean.Employee;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("com.example.liujianming.testdemo1.test.bean.Employee");
        Class c2 = Employee.class;
        Employee employee = new Employee("小明", "18", "写代码", 1, "java攻城狮",10000);
        Class c3 = employee.getClass();

        if (c1 == c2 && c1 == c3) {
            System.out.println("c1、c2、c3为同一个对象");
            System.out.println(c1);
        }
    }
}
