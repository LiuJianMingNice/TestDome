package com.example.javaprogrammingideas.test;

/**
 * ClassName:TerminationCondition
 * Package:com.example.javaprogrammingideas.test
 * Description:
 *
 * @date:21-3-26 下午4:31
 * @author:liujianming
 */

class Book {
    boolean checkedOut = false;
    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize(){
        System.out.println("finalize===>>>" + checkedOut);
        if (checkedOut)
            System.out.println("Error: checked out");
    }
}
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        System.out.println("111111");
        new Book(true);
        System.out.println("222222");
        System.gc();
    }
}
