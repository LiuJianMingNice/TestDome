package com.example.liujianming.testdemo1.test.architect.generic;

import java.util.ArrayList;

public class TestWildCard {

    public static void main(String[] args) {

        ArrayList<Student> list1 = new ArrayList<>();
        list1.add(new Student("男",14));

        ArrayList<Student> list2 = new ArrayList<>();
        list2.add(new Student("女",15));

        list1.addAll(list2);

        for(Student student : list1) {
            System.out.println("age===>>> " + student.mAge);
        }


        ArrayList<BaseStuddent> list3 = new ArrayList<>();

        list3.add(new BaseStuddent("男",17));

        list1.addAll(list3);

        for(Student student : list1) {
            System.out.println("age===>>> " + student.mAge);
        }

    }
}
