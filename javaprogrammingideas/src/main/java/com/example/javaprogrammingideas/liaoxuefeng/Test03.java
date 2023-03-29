package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import androidx.annotation.RequiresApi;

/**
 * ClassName:Test03
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-8
 * @author:liujianming
 */
public class Test03{
    public static void main(String[] args) {
        Inner inner = new Inner();
        inner.hi();
    }

    private static void hello() {
        System.out.println("private hello!");
    }

    private static void nihaoa(int number) {
        number = 4;
    }

    static class Inner {
        public void hi() {
            Test03.hello();
        }
    }
}


