package com.example.liujianming.testdemo1.designpatterns.状态模式;

public class Context {

    private PersonState mPersonState;

    public void setPersonState(PersonState personState) {
        mPersonState = personState;
    }

    public void fallInLove() {
        System.out.println("坠入爱河");
        setPersonState(new LoveState());
    }

    public void disappointmentInLove() {
        System.out.println("单身狗状态");
        setPersonState(new DogState());
    }

    public void movies() {
        mPersonState.movies();
    }

    public void shopping() {
        mPersonState.shopping();
    }

}
