package com.example.liujianming.testdemo1.test.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Test {

    public static void main(String[] args) throws Exception,IOException {
//        SerializeUser();
        DeSerializeUser();
    }

    //序列化方法
    private static void SerializeUser() throws FileNotFoundException,IOException {
        User user = new User();
        user.setName("Java的架构师技术栈");
        user.setAge(24);
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/liujianming/shares/序列化文件/test.txt"));
//        oos.writeUTF("utf-8");
        oos.writeObject(user);
        oos.close();
        System.out.println("序列化对象成功");
    }

    //反序列化方法
    private static void DeSerializeUser() throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("/home/liujianming/shares/序列化文件/test.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        System.out.println("反序列化对象成功" + newUser.toString());
    }
}
