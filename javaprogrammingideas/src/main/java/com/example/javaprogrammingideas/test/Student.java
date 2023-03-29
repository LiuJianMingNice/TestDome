package com.example.javaprogrammingideas.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * ClassName:Student
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
public class Student extends Thread implements Comparable {
    private int age;
    private String name;
    private String tel;
    private int height;

    public Student(String name, int age, String tel, int height) {
        this.age = age;
        this.name = name;
        this.tel = tel;
        this.height = height;
    }

    public static void main(String args[]) throws InterruptedException {
        Student stu1 = new Student("张三", 21, "156482", 172);
        Student stu2 = new Student("李四", 18, "561618", 168);
        Student stu3 = new Student("王五", 19, "841681", 170);
        Student stu4 = new Student("赵六", 20, "563543", 180);

        List<Student> list = new ArrayList<Student>();
        list.add(stu3);
        list.add(stu1);
        list.add(stu4);
        list.add(stu2);
        System.out.println("------排序前---------");
        Iterator<Student> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        Collections.sort(list);
        System.out.println("-------按照年龄排序后--------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
    @Override
    public int compareTo(Object o) {
        //使用当前对象的年龄和其他对象的年龄比较，如果<0返回负数，>0返回正数，=0返回0
        int z = this.age - ((Student)o).age;
        if (z<0)
            return -1;  //返回其他负数也行
        else if(z == 0)
            return 0;
        else
        return 1;  //返回其他正数也行
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", height=" + height +
                '}';
    }
}
