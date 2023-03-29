package com.example.javaprogrammingideas.test;

import java.util.Scanner;

/**
 * ClassName:ScannerDelimiter
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-21
 * @author:liujianming
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12, 42, 78, 99, 42");
        scanner.useDelimiter("\\s*,\\s*");
        while(scanner.hasNextInt())
            System.out.println(scanner.nextInt());
    }
}
