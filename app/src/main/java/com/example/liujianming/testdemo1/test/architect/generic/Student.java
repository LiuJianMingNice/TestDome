package com.example.liujianming.testdemo1.test.architect.generic;

public class Student {

    public String mSex;
    public int mAge;
    public String mColor;

    public Student() {

    }

    public Student(String mSex, int mAge) {
        this.mSex = mSex;
        this.mAge = mAge;
    }

    public Student(String mSex, int mAge, String mColor) {
        this.mSex = mSex;
        this.mAge = mAge;
        this.mColor = mColor;
    }

    public void getCount() {

    }
}
