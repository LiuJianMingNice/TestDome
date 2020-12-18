package com.example.liujianming.testdemo1.简书Demo.javatest;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
//        multiplicationTable();
        arrayMax();
    }

    //九九乘法表
    public static void multiplicationTable() {
        for (int i = 1; i <= 9; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i*j + "\t");
            }
        System.out.println();
        }
    }

    /**
     * 定义一个二维数组，int[2][4]，要求是循环输入8个整数，存入到数组中，然后输出这个数组中的最大值。
     */
    public static void arrayMax() {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[2][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("请输入" + i + "行" + j + "列数字");
                array[i][j] = scanner.nextInt();  //获取输入数存在对应行列位置
            }
        }
        int max = array[0][0]; //假定第一个数最大
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > max) {  //有更大就替换
                    max = array[i][j];
                }
            }
        }
        System.out.println("最大数为：" + max);
    }
}
