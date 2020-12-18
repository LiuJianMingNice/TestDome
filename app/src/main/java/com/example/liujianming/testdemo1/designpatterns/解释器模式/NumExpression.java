package com.example.liujianming.testdemo1.designpatterns.解释器模式;

import android.content.Context;

public class NumExpression extends ArithmeticExpression {
    private String strNum;

    public NumExpression(String strNum) {
        this.strNum = strNum;
    }
    @Override
    public Object interpret(Context context) {
        return Integer.parseInt(strNum);
    }
}

class VarExpression extends ArithmeticExpression {
    private String var;

    public VarExpression(String var) {
        this.var = var;
    }

    @Override
    public Object interpret(Context context) {
        return var;
    }
}
