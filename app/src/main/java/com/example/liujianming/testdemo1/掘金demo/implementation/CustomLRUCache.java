package com.example.liujianming.testdemo1.掘金demo.implementation;

import com.example.liujianming.testdemo1.掘金demo.interfaces.ICache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CustomLRUCache<K, V> implements ICache<K, V> {

    //缓存键的最大数量
    private int keyMaxNum;

    //双向循环链表头结点
    private Node<K, V> head;

    //缓存数据
    private Map<K, Node<K, V>> cacheMap = new ConcurrentHashMap<>();

    public CustomLRUCache(int keyMaxNum) {
        if (keyMaxNum < 1) {
            throw new IllegalArgumentException("keyMaxNum has to be greater than 0");
        }

        this.keyMaxNum = keyMaxNum;
    }

    @Override
    public void put(K key, V value) {
        if (cacheMap.size() >= keyMaxNum && !cacheMap.containsKey(key)) {
            Node<K, V> tail = head;
            remove(tail.key);
        }

        Node<K, V> node = cacheMap.get(key);
        if (node != null) {
            //当前结点是头结点时，就不更新结点位置
            if (node == head) {
                return;
            }

            //存在前驱结点时，将前驱结点next指针指向后继结点
            if (node.prev != node) {
                node.prev.next = node.next;
            }

            //存在后继结点时，将后继结点prev指针指向前驱结点
            if (node.next != node) {
                node.next.prev = node.prev;
            }
        } else {
            node = new Node<>(key, value, null, null);
        }

        //头结点为空时，此时为链表无数据，让第一个结点前后指针指向自己
        if (head == null) {
            node.prev = node;
            node.next = node;
        } else {
            //头结点的前驱结点即tail尾结点
            Node<K, V> tail = head.prev;

            //修改当前结点前后指针
            node.prev = tail;
            node.next = tail.next;

            //修改head头结点prev指针，指向新的头结点
            tail.next.prev = node;

            //修改tail尾结点next指针，指向新的头结点
            tail.next = node;
        }

        //保存最新头结点数据
        head = node;

        //缓存数据
        cacheMap.put(key, node);
    }

    @Override
    public synchronized V get(K key) {
        Node<K, V> node = cacheMap.get(key);
        if (node ==null) {
            return null;
        }

        if (node != head) {
            //存在前驱结点时，将前驱结点next指针指向后继结点
            if (node.prev != node) {
                node.prev.next = node.next;
            }

            //存在后继结点时，将后继结点prev指针指向前驱结点
            if (node.next != node) {
                node.next.prev = node.prev;
            }

            //头结点的前驱结点即tail尾结点
            Node<K, V> tail = head.prev;

            //修改当前结点前后指针
            node.prev = tail;
            node.next = tail.next;

            //修改head头结点prev指针，指向新的头结点
            tail.next.prev = node;

            //修改tail尾结点指针，指向新的头结点
            tail.next = node;

            //保存最新头结点数据
            head = node;
            cacheMap.put(key, node);
        }
        return node.value;
    }

    @Override
    public synchronized void remove(K key) {
        Node<K, V> node = cacheMap.get(key);
        if (node != null) {
            //存在前驱结点时，将前驱结点next指针指向后继结点
            if (node.prev != node) {
                node.prev.next = node.next;
            }

            //存在后继结点时，将后继结点prev指针指向前驱结点
            if (node.next != node) {
                node.next.prev = node.prev;
            }

            //移除的是头结点时
            if (node == head) {
                //链表仅包含一个结点时，head置空，否则指向后继结点
                if (node == head.next) {
                    head = null;
                } else {
                    head = head.next;
                }
            }
            cacheMap.remove(key);
        }
    }

    @Override
    public boolean containsKey(K key) {
        return cacheMap.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return cacheMap.isEmpty();
    }

    @Override
    public void clear() {
        head = null;
        cacheMap.clear();
    }

    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> prev, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
