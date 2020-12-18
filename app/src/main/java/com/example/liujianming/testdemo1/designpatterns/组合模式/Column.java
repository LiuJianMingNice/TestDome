package com.example.liujianming.testdemo1.designpatterns.组合模式;

import java.util.Iterator;

public class Column extends PageElement{
    public Column(String name) {
        super(name);
    }

    @Override
    public void addPageElement(PageElement pageElement) {
        mPageElements.add(pageElement);
    }

    @Override
    public void rmPageElement(PageElement pageElement) {
        mPageElements.remove(pageElement);
    }

    @Override
    public void clear() {
        mPageElements.clear();
    }

    @Override
    public void print(String placeholder) {
        System.out.println(placeholder + "-" + getName());
        Iterator<PageElement> i = mPageElements.iterator();
        while(i.hasNext()) {
            PageElement pageElement = i.next();
            pageElement.print(placeholder + " ");
        }
    }
}
