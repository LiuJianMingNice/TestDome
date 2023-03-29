package com.example.javaprogrammingideas.liaoxuefeng;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * ClassName:TestFile
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-12
 * @author:liujianming
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
//        testInputStream();
        customFilterInputStream();
    }

    private static void testInputStream() {
        String s = null;
        try(InputStream inputStream = new FileInputStream("/home/liujianming/桌面/FileTest/Read")){
            int n;
            StringBuilder sb = new StringBuilder();
            while ((n = inputStream.read()) != -1) {
                sb.append((char)n);
            }
            s = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

    private static void customFilterInputStream() throws IOException {
        byte[] data = "hello, world!".getBytes("UTF-8");
        try(CountInputStream inputStream = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println((char)n);
            }
            System.out.println("Total read " + inputStream.getBytesRead() + "bytes");
        }
    }
}

class CountInputStream extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    private int count = 0;
    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count ++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}
