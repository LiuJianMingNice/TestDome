package com.example.javaprogrammingideas.liaoxuefeng;

import android.util.Log;

import com.example.testlibrary.Utils;

import java.util.Scanner;

/**
 * ClassName:Test01
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-4-29
 * @author:liujianming
 */
public class Test01 {
    public static void main(String[] args) {
//        double d = 3.1415926;
//        System.out.printf("%.2f\n", d);
//        System.out.printf("%.4f\n", d);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input your name: ");
//        String name = scanner.nextLine();
//        System.out.println("Input your age: ");
//        int age = scanner.nextInt();
//        System.out.printf("Hi, %s, you are %d\n", name, age);

//        Scanner mScanner = new Scanner(System.in);
//        System.out.println("请输入你上次考试的成绩: ");
//        int score1 = mScanner.nextInt();
//        System.out.println("请输入你这次考试的成绩: ");
//        int score2 = mScanner.nextInt();
//        double percentOfScoreImprove = (double)(score2 - score1) / score1*100;
//        System.out.printf("这次考试提高的百分比:%.2f%% ", percentOfScoreImprove);
//
//        int caseNumber = 2;
//        switch (caseNumber) {
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            case 3:
//                System.out.println("3");
//                break;
////            default:
////                System.out.println("null");
////                break;
//        }

        System.out.println(test());
    }

    private static void testJar() {
        System.out.println(Utils.showLog());;
    }

    private static int test() {
        return 3 & 4;
    }
}
