package com.example.liujianming.testdemo1.test.serialization;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class User implements Serializable {
    //序列化ID
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "名字为：　" + name + ",年龄：" + age;
    }
}
