package com.example.javaprogrammingideas.test;

/**
 * ClassName:ArraysOfPrimitives
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-3-29 下午3:21
 * @author:liujianming
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        testArray();
        f(1, "Hello");
        f(2, "Hello", "World");
        f(0);
    }

    private static void f(int required, String... trailing) {
        System.out.print("required:" + required + " ");
        for (String s : trailing)
            System.out.print(s + " ");
        System.out.println();
    }

    private static void testArray() {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;

        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }

        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1[" + i + "] = " + a1[i]);
        }
    }
}
