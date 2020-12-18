package com.example.liujianming.testdemo1.test.architect.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestIO {

    public static void FileInputStreatTest() throws IOException {
        FileInputStream fis = new FileInputStream("/home/liujianming/桌面/TestIO/tmp2.txt");
        byte[] buf = new byte[1024];

        int hasRead = 0;

        //read()返回的是单个字节数据(字节数据可以直接专程int类型),但是read(buf)返回的是读取到的字节数，真正的数据保存在buf中
        while ((hasRead = fis.read(buf)) > 0) {
            //每次最多将1024个字节转换成字符串,这里tmp2.txt中的字符小于1024,所以一次就读完了
            //循环次数 = 文件字符数除以buf长度
            System.out.println(new String(buf,0,hasRead));
        }
        fis.close();
    }

    public static void FileReaderTest() throws IOException {
        try(FileReader fr = new FileReader("/home/liujianming/桌面/TestIO/tmp4.txt")) {
            char[] buf = new char[32];
            int hasRead = 0;

            while ((hasRead = fr.read(buf)) > 0) {
                System.out.println(new String(buf,0,hasRead));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void FileOutputStreatTest() throws FileNotFoundException {
        try (FileInputStream fis = new FileInputStream("/home/liujianming/桌面/TestIO/tmp2.txt");
             FileOutputStream fos = new FileOutputStream("/home/liujianming/桌面/TestIO/tmp3.txt");){
            byte[] buf = new byte[4];
            int hasRead = 0;
            while ((hasRead = fis.read(buf)) > 0) {
                fos.write(buf,0,hasRead);
                System.out.println("write success");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void FileWriterTest() throws IOException {
        try(FileWriter fw = new FileWriter("/home/liujianming/桌面/TestIO/tmp4.txt")) {
            fw.write("天王盖地虎\r\n");
            fw.write("宝塔镇河妖\r\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        File file2 = new File("/home/liujianming/桌面/TestIO/tmp2.txt");
        File file3 = new File("/home/liujianming/桌面/TestIO/tmp3.txt");
        File file4 = new File("/home/liujianming/桌面/TestIO/tmp4.txt");
        file2.createNewFile();
        file3.createNewFile();
        file4.createNewFile();
//        FileInputStreatTest();
        FileReaderTest();
//        FileOutputStreatTest();
//        FileWriterTest();
    }
}
