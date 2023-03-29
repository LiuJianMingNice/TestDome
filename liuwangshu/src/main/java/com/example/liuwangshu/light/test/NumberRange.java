package com.example.liuwangshu.light.test;

/**
 * ClassName:NumberRange
 * Package:com.example.liuwangshu.light.test
 *
 * @date:21-5-27
 * @author:liujianming
 */
public class NumberRange {
    private volatile int lower, upper;
    public int getLower() {
        return lower;
    }
    public int getUpper() {
        return upper;
    }
    public void setLower(int value) {
        if (value > upper) throw new IllegalArgumentException();
        lower = value;
    }
    public void setUpper(int value) {
        if (value < lower) throw new IllegalArgumentException();
        upper = value;
    }
}
