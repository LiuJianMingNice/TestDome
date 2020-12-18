package com.example.liujianming.testdemo1.designpatterns.简单工厂模式;

public class Operation {

    public static double GetResult(double numberA, double numberB, String operate) {
        double result = 0d;
        switch (operate) {
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
            case  "/":
                result = numberA / numberB;
                break;
        }
        return result;
    }
}
