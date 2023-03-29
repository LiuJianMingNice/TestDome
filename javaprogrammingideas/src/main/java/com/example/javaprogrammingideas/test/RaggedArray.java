package com.example.javaprogrammingideas.test;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName:RaggedArray
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
public class RaggedArray {
    public static void main(String[] args) {
        Random random = new Random(47);
        int[] [] [] a = new int[random.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[random.nextInt(5)] [];
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = new int[random.nextInt(5)];
        }
        System.out.println(Arrays.deepToString(a));
    }
}
