package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.math.BigInteger;

import androidx.annotation.RequiresApi;

/**
 * ClassName:Test04
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-8
 * @author:liujianming
 */
public class Test04 {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
//        Outer.StaticNested sn = new Outer.StaticNested();
//        sn.hello();

//        String s = "A,,B;C ,D";
//        System.out.println(s);
//        s.replaceAll("[\\,\\;\\s]+", ",");
//        System.out.println(s);

//        String s = "A,B,C,D";
//        System.out.println(s);
//        String[] ss = s.split("\\,");
//        for (String s1 : ss) {
//            System.out.println(s1);
//        }

//        String[] arr = {"A", "B", "C"};
//        String s = String.join("***",arr);
//        System.out.println(s);
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780
        Math.log10(100);
    }
}

class Outer {
    private static String NAME = "OUTER";
    private String name;
    Outer(String name) {
        this.name = name;
    }

    static class StaticNested {
        void hello() {
            System.out.println("Hello, " + Outer.NAME);
        }
    }
}
