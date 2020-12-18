package com.example.liujianming.testdemo1.designpatterns.装饰者模式;

public class Test {

    public static void main(String[] args) {
        Room newRoom = new NewRoom();
        RoomDecorator bedroom = new Bedroom(newRoom);
        bedroom.fitment();
        RoomDecorator kitchen = new Kitchen(newRoom);
        kitchen.fitment();
    }

}
