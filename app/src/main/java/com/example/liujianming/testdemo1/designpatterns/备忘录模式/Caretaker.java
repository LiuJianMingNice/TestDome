package com.example.liujianming.testdemo1.designpatterns.备忘录模式;

public class Caretaker {
    private Memento mMemento;

    public Memento getmMemento() {
        return mMemento;
    }

    public void setmMemento(Memento mMemento) {
        this.mMemento = mMemento;
    }
}
