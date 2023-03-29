package com.example.audioandvideo;

import android.util.Log;

public class Test {

    public static void  main(String[] args) {
        System.out.println("Test的main方法");
        Log.i("ljm","Test的main方法");
    }

    public Test() {
        System.out.println("Test的构造函数");
        Log.i("ljm","Test的构造函数");
    }

    {
        System.out.println("Test的构造代码块");
        Log.i("ljm","Test的构造代码块");
    }

    static {
        System.out.println("Test的静态代码块");
        Log.i("ljm","Test的静态代码块");
    }

}


