package com.example.kotlinprojection.test.java.demo;

import com.example.kotlinprojection.test.java.interfaces.ReturnOneParam;

/**
 * ClassName:LambdaTest1
 * Package:com.example.kotlinprojection.test.java.demo
 *
 * @date:21-7-14
 * @author:liujianming
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        ReturnOneParam lambda1 = a -> doubleNum(a);
        System.out.println(lambda1.method(3));
    }
    /**
     * 要求
     * 1.参数数量和类型要与接口中定义的一致
     * 2.返回值类型要与接口中定义的一致
     */
    public static int doubleNum(int a) {
        return a * 2;
    }

    public int addTwo(int a) {
        return a + 2;
    }
}
