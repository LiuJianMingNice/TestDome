package com.example.liujianming.testdemo1.designpatterns.适配器模式;

public class Test {
    public static void main(String[] args) {
//        Electric electric = new Electric();
//        System.out.println("默认电压：" + electric.output_220v());
//
//        Adapter phoneAdapter = new PhoneAdapter(electric);
//        System.out.println("适配转换后的电压：" + phoneAdapter.convert_5v());
        Player bde = new Forwards("巴蒂尔");
        bde.Defense();
        Player md = new Guards("麦迪");
        md.Attack();
        Player ym = new Translator("姚明");
        ym.Attack();
        ym.Defense();
    }
}
