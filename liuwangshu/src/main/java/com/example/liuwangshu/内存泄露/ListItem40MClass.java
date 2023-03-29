package com.example.liuwangshu.内存泄露;

/**
 * ClassName:ListItem40MClass
 * Package:com.example.liuwangshu.内存泄露
 *
 * @date:7/26/21
 * @author:liujianming
 */
public class ListItem40MClass {
    byte[] content = new byte[1000 * 1000 * 40];
    ListItem40MClass() {
        for (int i = 0; i < content.length; i++) {
            content[i] = 1;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    ListItem40MClass next;
}
