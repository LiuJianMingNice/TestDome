package com.example.javaprogrammingideas.test;

import java.util.Random;

/**
 * ClassName:CompType
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
public class CompType implements Comparable<CompType> {
    int i;
    int j;
    private static int count = 1;
    public CompType(int n1, int n2) {
        i = n1;
        j = n2;
    }
    public String toString() {
        String result = "[1 = " + i + ",j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }
    @Override
    public int compareTo(CompType rv) {
        return (i < rv.i ? -1 : (i == rv.i ? 0 : 1));
    }
    private static Random r = new Random(47);
}
