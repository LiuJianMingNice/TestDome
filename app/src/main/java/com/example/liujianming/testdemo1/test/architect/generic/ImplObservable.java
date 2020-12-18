package com.example.liujianming.testdemo1.test.architect.generic;

import androidx.lifecycle.Observer;

public class ImplObservable<T> implements Observable<T>{

    T t;
    private ImplObservable(T t) {
        this.t = t;
    }
    @Override
    public T call() {
        return null;
    }

    @Override
    public <R> Observable<R> map(Func1<T, R> fun1) {
        Observable<R> observer = ImplObservable.create(fun1.call(t));
        return observer;
    }

    @Override
    public Observable<T> doOnNext(Action<T> action) {
        action.callAction(t);
        return this;
    }

    public static <T> Observable<T> create(T t) {
        return new ImplObservable<T>(t);
    }
}
