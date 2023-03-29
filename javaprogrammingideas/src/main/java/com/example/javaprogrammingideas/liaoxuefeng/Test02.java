package com.example.javaprogrammingideas.liaoxuefeng;

import java.util.Arrays;

/**
 * ClassName:Test02
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-7
 * @author:liujianming
 */
public class Test02 {
    public static void main(String[] args) {
//        testWhile();
//        testFor();
//        testBubbleSort();
//        testTwoArrays();
//        testFindIndexByString();
        Student s = new Student("Xiao Ming", 12, 89);
    }

    private static void testWhile() {
        int sum = 0;
        int n = 1;
        while (n < 10) {
            sum = sum + n;
            n++;
            System.out.println("sum==>>> " + sum);
        }
    }

    private static void testFor() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    private static void testBubbleSort() {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        System.out.println(Arrays.toString(ns));
        for (int i = 0; i < ns.length - 1; i++) {
            for (int j = 0; j < ns.length - i - 1; j++) {
                if (ns[j] > ns[j + 1]) {
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(ns));
    }

    private static void testTwoArrays() {
        int[][] ns = {
                {1, 2, 3, 4},
                {32, 21, 23, 12},
                {54, 225, 34, 56}
        };
        System.out.println("数组：" + Arrays.toString(ns));
        System.out.println("数组：" + Arrays.deepToString(ns));
    }

    private static void testFindIndexByString() {
        String s = "Test string";
        int n1 = s.indexOf("t");
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Student extends Person {
    protected int score;

    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
}
