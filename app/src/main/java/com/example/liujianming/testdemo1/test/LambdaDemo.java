package com.example.liujianming.testdemo1.test;

public class LambdaDemo {
    public static void main(String[] args) {
        //接口中只定义了1个抽象方法，可以利用Lambda表达式来重写这唯一的一个抽象方法

        //方式一
        Cacl c = new Cacl() {
            @Override
            public double add(double i, double j) {
                return i + j;
            }
        };

        //方式二
        //表示重写Cacl中唯一的一个抽象方法add
        //Lambda表达式只能作用在函数式接口上
        Cacl c1 = (double a, double b) -> {
            return a + b;
        };

        //方法体只有一句，可以省略{}和return不写
        Cacl c2 = (double i, double j) -> i + j;

        //方法三
        //重写的是Cacl接口中的方法add
        //add方法的参数列表的类型是已知的
        //可以省略参数类型不写
        Cacl c3 = (x,y) -> x + y;

        System.out.println("c=== " + c.add(2,1));
        System.out.println("c1=== " + c1.add(2,2));
        System.out.println("c2=== " + c2.add(2,3));
        System.out.println("c3=== " + c3.add(2,4));
    }
}

interface Cacl{
    public double add(double i, double j);
}
