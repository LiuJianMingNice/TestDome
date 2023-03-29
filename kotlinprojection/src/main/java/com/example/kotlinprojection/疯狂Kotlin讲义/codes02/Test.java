package com.example.kotlinprojection.疯狂Kotlin讲义.codes02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Test
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 *
 * @date:21-7-15
 * @author:liujianming
 */
public class Test {
    public static void main(String[] args) {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2);
    }

    public void hello(List<String> list){}
//    public void hello(List<Integer> list) {}
}
