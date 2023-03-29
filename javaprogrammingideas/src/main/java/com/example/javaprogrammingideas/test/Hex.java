package com.example.javaprogrammingideas.test;

import android.widget.EditText;

/**
 * ClassName:Hex
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-20
 * @author:liujianming
 */
public class Hex {
    EditText editText;
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }
    public static void main(String[] args) throws Exception {

    }
    public void test() {
    }
}
