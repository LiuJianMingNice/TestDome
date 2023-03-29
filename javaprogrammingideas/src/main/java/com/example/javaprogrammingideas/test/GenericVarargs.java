package com.example.javaprogrammingideas.test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:GenericVarargs
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-25
 * @author:liujianming
 */
public class GenericVarargs {
    public static <T> List<T> makeList(T...args) {
        List<T> result = new ArrayList<T>();
        for(T item : args)
            result.add(item);
        return result;
    }
    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJLMNOPQRSTUNWXYZ".split(""));
        System.out.println(ls);
    }
}
