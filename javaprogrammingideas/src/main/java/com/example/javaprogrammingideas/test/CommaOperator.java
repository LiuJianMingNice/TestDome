package com.example.javaprogrammingideas.test;

/**
 * ClassName:CommaOperator
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-3-26 上午11:30
 * @author:liujianming
 */
public class CommaOperator {
    public static void main(String[] args) {
        for (int i =1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.println("i = " + i + " j = " + j);
        }
    }
}
