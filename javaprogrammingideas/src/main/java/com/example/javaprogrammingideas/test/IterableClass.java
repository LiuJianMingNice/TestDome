package com.example.javaprogrammingideas.test;

import java.util.Iterator;

import androidx.annotation.NonNull;

/**
 * ClassName:IterableClass
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-8
 * @author:liujianming
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how" + "we know the Earth to be banana-shaped.").split(" ");
    @NonNull
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        for(String s : new IterableClass())
            System.out.println(s + " ");
    }
}
