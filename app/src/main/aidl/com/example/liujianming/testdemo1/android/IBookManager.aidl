// IBookManager.aidl
package com.example.liujianming.testdemo1.android;

// Declare any non-default types here with import statements

import com.example.liujianming.testdemo1.android.Book;
import com.example.liujianming.testdemo1.android.IOnNewBookArrivedListener;

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    void addBook(in Book book);
    List<Book> getBookList();
    void registerListener(IOnNewBookArrivedListener listener);
    void unRegisterListener(IOnNewBookArrivedListener listener);
}
