package com.example.javaprogrammingideas.liaoxuefeng;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * ClassName:Test05
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-10
 * @author:liujianming
 */
public class Test05 {
    public static void main(String[] args) throws Exception {
//        testGBK();
//        testException();
//        getAllException();
        testNullPointerException();
    }

    private static void testGBK() {
        byte[] bs = new byte[0];
        try {
            bs = toGBK("中文");
            System.out.println(Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }

    private static void testException() {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static void process2() {
        throw new NullPointerException();
    }

    private static void getAllException() throws Exception {
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }

    private static void testNullPointerException() {
        Person1 person1 = new Person1();
        System.out.println(person1.address.city.toLowerCase());
    }

//    private static void testLogger() {
//        Logger logger = Logger.getLogger(Test05.class.getName());
//        logger.info("Start process...");
//        try {
//            "".getBytes("invalidCharsetName");
//        } catch (UnsupportedEncodingException e) {
//
//        }
//        logger.info("Process end.");
//    }
}

class Person1 {
    String[] name = new String[2];
    Address address = new Address();
}

class Address {
    String city;
    String street;
    String zipcode;
}
