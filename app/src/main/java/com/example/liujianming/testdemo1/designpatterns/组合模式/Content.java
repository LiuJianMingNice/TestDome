package com.example.liujianming.testdemo1.designpatterns.组合模式;

public class Content extends PageElement {
    public Content(String name) {
        super(name);
    }

    @Override
    public void addPageElement(PageElement pageElement) {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void rmPageElement(PageElement pageElement) {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void print(String placeholder) {
        System.out.println(placeholder + "-" + getName());
    }
}
