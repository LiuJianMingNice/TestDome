package com.example.javaprogrammingideas.test;

import java.util.Arrays;

/**
 * ClassName:MultidimensionalPrimitiveArray
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
public class MultidimensionalPrimitiveArray {
    public static void main(String[] args) {
        int[] [] a = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(Arrays.deepToString(a));
    }
}
