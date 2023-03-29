package com.example.javaprogrammingideas.liaoxuefeng;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:TestRegex
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-14
 * @author:liujianming
 */
public class TestRegex {
    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        testPattern();
//        testGetTimeString();
        testSearchString();
    }

    private static void test01() {
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex));
        System.out.println("2119".matches(regex));
    }

    private static void test02() {
        String re1 = "abc";
        System.out.println("abc".matches(re1));
        System.out.println("Abc".matches(re1));
        System.out.println("abcd".matches(re1));

        String re2 = "a\\&c";
        System.out.println("a&c".matches(re2));
        System.out.println("a-c".matches(re2));
        System.out.println("a&&c".matches(re2));
    }

    private static void test03() {
        String regex = "[1-9]\\d{6,7}";
        System.out.println("212345678".matches(regex));
    }

    private static void test04() {
        String re = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn Go".matches(re));
    }

    private static void test05() {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("123000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1));
            System.out.println("group2=" + matcher.group(2));
        }
    }

    private static void testPattern() {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1);
            System.out.println(g2);
        } else {
            System.out.println("匹配失败");
        }

    }

    private static void testGetTimeString() {
        Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher m = p.matcher("23:01:59");
        if (m.matches()) {
            String hour = m.group(1);
            String minute = m.group(2);
            String second = m.group(3);
            System.out.println(hour + ":" + minute + ":" + second);
        }
    }

    private static void testSearchString() {
        String s = "the quick brown fox jumps over the lazy dog";
        Pattern pattern = Pattern.compile("\\wo\\w");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String sub = s.substring(matcher.start(), matcher.end());
            System.out.println(sub);
        }
    }

}

