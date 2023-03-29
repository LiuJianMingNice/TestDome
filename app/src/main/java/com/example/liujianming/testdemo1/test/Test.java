package com.example.liujianming.testdemo1.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
//        testRegex();
        DtoB(2.0);
    }
    //十进制转二进制
    public static void DtoB(double d) {
        if (d / 2 == 0) {
            System.out.println("d===>>> " + d);
            DtoB(d);
        }
        System.out.println("d===>>> " + d);

    }

    public static void testRegex() {

        String regex = "((A+)(B(C)))";
        String input = "HBC-AABC-AAAAABCD";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int groupCount = matcher.groupCount();

        while (matcher.find()) {
            System.out.println("匹配结果: ");
            for (int i = 0; i < groupCount; i++) {
                System.out.println("group" + i + ":" + matcher.group(i) + "\t");
            }
            System.out.println();
        }
    }
}
