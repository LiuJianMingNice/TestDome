package com.example.javaprogrammingideas.test;

/**
 * ClassName:NewEnclosing
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-6
 * @author:liujianming
 */
public class NewEnclosing {
    {
        class BlockLocal {
            void print() {

            }
        }
    }

    void run() {
        class Local {
            static final int a = 3;
//            static int b = 5;
            String c;
            double d;
            void run() {

            }
        }
        Local local = new Local();
        local.run();
    }

    public static void main(String[] args) {
        NewEnclosing newEnclosing = new NewEnclosing();
        newEnclosing.run();
    }
}
