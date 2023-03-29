package com.example.javaprogrammingideas.test;

import java.util.Random;

/**
 * ClassName:ClassInitialization
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-21
 * @author:liujianming
 */
class InitTable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.random.nextInt(1000);
}

class InitTable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing InitTable2");
    }
}

class InitTable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing InitTable3");
    }
}

public class ClassInitialization {
    public static Random random = new Random(47);
    public static void main(String[] args) throws Exception {
        Class initTable = InitTable.class;
        System.out.println("After creating InitTable ref");
        System.out.println(InitTable.staticFinal);
        System.out.println(InitTable.staticFinal2);
        System.out.println(InitTable2.staticNonFinal);
        Class initTable3 = Class.forName("InitTable3");
//        Class initTable3 = InitTable3.class;
        System.out.println("After creating InitTable3 ref");
        System.out.println(InitTable3.staticNonFinal);

    }
}
