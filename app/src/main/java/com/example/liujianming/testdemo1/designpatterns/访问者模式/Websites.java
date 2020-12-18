package com.example.liujianming.testdemo1.designpatterns.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Websites {

    List<Web> mWebList = new ArrayList<>();

    public void accept(Visitor visitor) {
        Iterator<Web> iterator = mWebList.iterator();
        while(iterator.hasNext()) {
            iterator.next().accept(visitor);
        }
    }

    public void addWeb(Web web) {
        mWebList.add(web);
    }
}
