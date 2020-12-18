package com.example.liujianming.testdemo1.test.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {
    public static void main(String[] args) {
        String FILE_PATH = "info.txt";
        try {
            File f = new File(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH));

            Phone phone = new Phone();
            phone.setColor("0xFFFFFF");
            phone.setBrand("OnePlus");
            phone.setPrice(3000);

            Card card1 = new Card("12345678901");
            Card card2 = new Card("98765432109");
            phone.setCard1(card1);
            phone.setCard2(card2);

            out.writeObject(phone);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
