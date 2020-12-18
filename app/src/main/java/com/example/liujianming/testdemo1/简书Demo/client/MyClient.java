package com.example.liujianming.testdemo1.简书Demo.client;


import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyClient {
    public static void main(String[] args) throws Exception {
        Socket socket =null;
        BufferedReader in = null;
        PrintWriter out = null;
        String aaa;

        BufferedReader input = null;
        //请求指定ip和端口号的服务器
        socket = new Socket("127.0.0.1", 1314);

        while (true) {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);

            input = new BufferedReader(new InputStreamReader(System.in));

            String info = input.readLine();

            out.println(info);

            String str = in.readLine();

            System.out.println("客户端显示--->>> 服务器的信息： " + str);
        }
    }

    public void testCache() {
        List<Field> newCache = new ArrayList<>();
        try {
        Class cache = Integer.class.getDeclaredClasses() [0];
            Field myCache = cache.getDeclaredField("cache");
            myCache.setAccessible(true);
        } catch (Exception e) {

        }
    }

}
