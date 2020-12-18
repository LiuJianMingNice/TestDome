package com.example.liujianming.testdemo1.test.bean;

import java.io.Serializable;

public class Card implements Serializable {
    private String number;

    public Card(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

