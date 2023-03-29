package com.example.javaprogrammingideas.test;

import java.util.Arrays;

/**
 * ClassName:ArrayIsNotIterable
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-8
 * @author:liujianming
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib)
            System.out.print(t + " ");
    }
    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
