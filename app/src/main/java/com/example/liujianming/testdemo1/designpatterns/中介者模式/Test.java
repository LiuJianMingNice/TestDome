package com.example.liujianming.testdemo1.designpatterns.中介者模式;

public class Test {
    public static void main(String[] args) {
        Lianjia houseMediator = new Lianjia();
        Purchaser purchaser = new Purchaser(houseMediator);
        Landlord landlord = new Landlord(houseMediator);
        houseMediator.setLandlord(landlord);
        houseMediator.setPurchaser(purchaser);

        landlord.send("出售一套别墅");
        System.out.println("----------------");
        purchaser.send("求购一套学区房");
    }
}
