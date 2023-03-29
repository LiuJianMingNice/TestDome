package com.example.javaprogrammingideas.test;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName:IceCream
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
public class IceCream {
    private static Random random = new Random(47);
    static final String[] FLAVORS = {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
                                        "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};
    public static String[] flavorSet(int n) {
        if (n > FLAVORS.length) throw new IllegalArgumentException("Set too big");
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do
                t = random.nextInt(FLAVORS.length);
            while(picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(flavorSet(3)));
    }
}
