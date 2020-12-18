package com.example.liujianming.testdemo1.designpatterns.原型模式;

public class Card implements Cloneable {
    private int num;

    private Spec spec = new Spec();

    public Card() {
        System.out.println("Card执行构造函数");
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setSpec(int length, int width) {
        spec.setLength(length);
        spec.setWidth(width);

    }

    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", spec=" + spec +
                '}';
    }

    @Override
    protected Card clone() throws CloneNotSupportedException {
        System.out.println("clone时不执行构造函数");
        Card card = (Card) super.clone();
        card.spec = (Spec) spec.clone();
        return card;
    }
}
