package com.example.liujianming.testdemo1.test.architect.generic;

public interface Observable<T> {
    public T call();

    <R> Observable<R> map(Func1<T,R> fun1);

    Observable<T> doOnNext(Action<T> action);
}
