package com.example.javaprogrammingideas.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:FillingLists
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-26
 * @author:liujianming
 */
class StringAddress {
    private String s;
    public StringAddress(String s) {
        this.s = s;
    }
    public String toString() {
        return super.toString() + " " + s;
    }
}
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
