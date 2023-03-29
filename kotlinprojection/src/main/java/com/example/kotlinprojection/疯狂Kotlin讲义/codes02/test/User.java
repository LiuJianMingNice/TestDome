package com.example.kotlinprojection.疯狂Kotlin讲义.codes02.test;

import java.util.Random;

/**
 * ClassName:User
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02.test
 *
 * @date:21-7-17
 * @author:liujianming
 */
public class User {
    private String name;
    //name的setter和getter方法
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    //married的setter和getter方法
    public void setMarried(boolean married) {
        System.out.println("调用setMarried方法，参数为：" + married);
    }
    public boolean isMarried() {
        return true;
    }
    public int getAge() {
        return new Random().nextInt(100);
    }
}
