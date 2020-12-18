package com.example.liujianming.testdemo1.designpatterns.解释器模式;

import android.content.Context;

public class AddExpression extends ArithmeticExpression {
    private ArithmeticExpression left, right;

    public AddExpression(ArithmeticExpression left, AddExpression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public Object interpret(Context context) {
//        return context.get((String)left.interpret(context)) + context.get((String)right.interpret(context));
        return null;
    }
}
