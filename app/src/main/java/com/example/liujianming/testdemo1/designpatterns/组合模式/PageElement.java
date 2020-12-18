package com.example.liujianming.testdemo1.designpatterns.组合模式;

import java.util.ArrayList;
import java.util.List;

public abstract class PageElement {

    protected List<PageElement> mPageElements = new ArrayList<>();
    private String name;

    public PageElement(String name) {
        this.name = name;
    }

    public abstract void addPageElement(PageElement pageElement);

    public abstract void rmPageElement(PageElement pageElement);

    public abstract void clear();

    public abstract void print(String placeholder);

    public String getName() {
        return name;
    }
}
