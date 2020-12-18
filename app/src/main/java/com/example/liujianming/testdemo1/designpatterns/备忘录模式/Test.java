package com.example.liujianming.testdemo1.designpatterns.备忘录模式;

public class Test {

    public static void main(String[] args) {
        System.out.println("首次进入游戏");
        Game game = new Game();
        game.play();
        Memento memento = game.createMemento();
        Caretaker caretaker = new Caretaker();
        caretaker.setmMemento(memento);
        game.exit();

        System.out.println("-------------");
        System.out.println("二次进入游戏");
        Game secondGame = new Game();
        secondGame.setMemento(caretaker.getmMemento());
        secondGame.play();
        secondGame.exit();
    }
}
