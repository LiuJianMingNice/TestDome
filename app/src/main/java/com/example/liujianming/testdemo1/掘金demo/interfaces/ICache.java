package com.example.liujianming.testdemo1.掘金demo.interfaces;

public interface ICache<K, V> {
    void put(K key, V value);
    V get(K key);
    void remove(K key);
    boolean containsKey(K key);
    boolean isEmpty();
    void clear();
}
