package com.example.liujianming.testdemo1.designpatterns.适配器模式;

public class PhoneAdapter implements Adapter {

    private Electric mElectric;

    public PhoneAdapter(Electric electric) {
        mElectric = electric;
    }

    @Override
    public int convert_5v() {
        System.out.println("适配器开始工作");
        System.out.println("输入电压：" + mElectric.output_220v());
        System.out.println("输出电压：" + 5);
        return 5;
    }
}
