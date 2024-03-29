package com.example.javaprogrammingideas.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * ClassName:PriortyQueueDemo
 * Package:com.example.javaprogrammingideas.test
 *
 * @date:21-4-8
 * @author:liujianming
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(random.nextInt(i + 10));
        QueueDemo.printQ(priorityQueue);
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.<Integer>reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<>(strings.size(), Collections.<String>reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);

        Set<Character> characterSet = new HashSet<>();
        for (char c : fact.toCharArray())
            characterSet.add(c);
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(characterSet);
        QueueDemo.printQ(characterPQ);
    }
}
