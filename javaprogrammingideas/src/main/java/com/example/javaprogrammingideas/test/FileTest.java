package com.example.javaprogrammingideas.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName:FileTest
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-27
 * @author:liujianming
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream("/home/liujianming/桌面/FileTest/file");
            fos = new FileOutputStream("/home/liujianming/桌面/FileTest/newFile");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            int hasRead = 0;
            while ((hasRead = bis.read(b)) > 0) {
                System.out.println(new String(b, 0 ,hasRead));
                bos.write(b, 0, hasRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bis.close();
            bos.close();
        }
    }
}
