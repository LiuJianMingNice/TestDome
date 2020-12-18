package com.example.liujianming.testdemo1.test.bean;

import java.io.Serializable;

public class Phone implements Serializable {

    private static final long serialVersionUID = -5391500252073798073L;
    private Card card1;
    private Card card2;
    private String brand;
    private String color;
    private int price;


    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
