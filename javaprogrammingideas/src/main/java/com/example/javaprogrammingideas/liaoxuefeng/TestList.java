package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.RequiresApi;

/**
 * ClassName:TestList
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-11
 * @author:liujianming
 */
public class TestList {
    public static void main(String[] args) {
//        testListIterator();
//        testFindMissingNumber();
//        testPersonList();
//        testMap();
//        testMap1();
//        testMap2();
//        testSet1();
//        testSet2();
        testPriorityQueue();
    }

    private static void testListIterator() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("banana");
        List<String> list1 = List.of("sss");
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String s = iterator.next();
            System.out.println(s);
        }
    }

    private static void testFindMissingNumber() {
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int removed = list.remove((int) (Math.random() * list.size()));
        System.out.println("removed: " + removed);
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list1.add(i);
        }
        System.out.println(list.toString());
        System.out.println(list1.toString());
        for (int i = 0; i < list1.size(); i++) {
            if (!list.contains(list1.get(i))) {
                return list1.get(i);
            }
        }
        return 0;
    }

    private static void testPersonList() {
        List<Person3> list = new ArrayList<>();
        list.add(new Person3("xiao", "Ming", 18));
        list.add(new Person3("xiao", "Hong", 25));
        list.add(new Person3("Bob", "Smith", 20));
        boolean exist = list.contains(new Person3("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功" : "测试失败");
    }

    private static void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 789);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int price = map.get(key);
            System.out.println("price: " + price);
        }
    }

    private static void testMap1() {
        Map<Person4, Integer> map = new TreeMap<>(new Comparator<Person4>() {
            @Override
            public int compare(Person4 o1, Person4 o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        map.put(new Person4("Tom"), 1);
        map.put(new Person4("Bob"), 2);
        map.put(new Person4("Lily"), 3);
        for (Person4 key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Person4("Bob")));
    }

    private static void testMap2() {
        Map<Student1, Integer> map = new TreeMap<>(new Comparator<Student1>() {
            @Override
            public int compare(Student1 o1, Student1 o2) {
                if (o1.score == o2.score) {
                    return 0;
                }
                return o1.score > o2.score ? -1 : 1;
            }
        });
        map.put(new Student1("Tom", 77), 1);
        map.put(new Student1("Bob", 66), 2);
        map.put(new Student1("Lily", 99), 3);
        for (Student1 key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student1("Bob", 66)));
    }

    private static void testSet1() {
        Set<String> set = new TreeSet<>();
        set.add("apple");
        set.add("pear");
        set.add("banana");
        set.add("orange");
        for (String s : set) {
            System.out.println("s: " + s);
        }
    }

    private static void testSet2() {
        List<Message> received = new ArrayList<>();
        received.add(new Message(1, "Hello!"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(4, "Bye"));
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        Set<Message> set = new HashSet<>();
        for (Message message : received) {
            System.out.println("sequence: " + message.sequence);
            set.add(message);
        }
        received.clear();
        for (Message message : set) {
            System.out.println("message: " + message.text);
            received.add(message);
        }
        return received;
    }

    private static void testPriorityQueue() {
        Queue<User> queue = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            queue = new PriorityQueue<>(new UserComparator());
        }
//        queue.offer(new User("Bob", "A1"));
//        queue.offer(new User("Alice", "A2"));
//        queue.offer(new User("Boss", "V1"));
//        queue.offer(new User("Jon", "A10"));
//        queue.offer(new User("Amy", "A9"));
        queue.offer(new User("ps1", "B2"));
        queue.offer(new User("ps2", "C4"));
        queue.offer(new User("ps3", "A15"));
        queue.offer(new User("ps4", "A3"));
        queue.offer(new User("boss1", "V8"));
        queue.offer(new User("boss2", "V1"));
        queue.offer(new User("ps5", "A6"));
        queue.offer(new User("ps6", "A12"));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class Person3 {
    String firstName;
    String lastName;
    int age;

    public Person3(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person3 person3 = (Person3) o;
        return age == person3.age &&
                Objects.equals(firstName, person3.firstName) &&
                Objects.equals(lastName, person3.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}

class Person4 {
    public String name;

    Person4(String name) {
        this.name = name;
    }

    public String toString() {
        return "{Person: " + name + "}";
    }
}

class Student1 {
    public String name;
    public int score;

    Student1(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}

class Message {
    public final int sequence;
    public final String text;

    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return sequence == message.sequence &&
                Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, text);
    }
}

class UserComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.number.charAt(0) == o2.number.charAt(0)) {

//            String regEx="[^0-9]";
//            Pattern p = Pattern.compile(regEx);
//            Matcher m1 = p.matcher(o1.number);
//            Matcher m2 = p.matcher(o2.number);
//            int number1 = Integer.parseInt(m1.replaceAll("").trim());
//            int number2 = Integer.parseInt(m2.replaceAll("").trim());
//            return number1 - number2;

//            int v1 = o1.number.length();
//            int v2 = o2.number.length();
//            String n1 = o1.number.substring(1, v1);
//            String n2 = o2.number.substring(1, v2);
//            // 负值，n1排前面
//            return Integer.parseInt(n1) - Integer.parseInt(n2);
            return Integer.parseInt(o1.number.substring(1)) - Integer.parseInt(o2.number.substring(1));
        }
        if (o1.number.charAt(0) == 'V') {
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}
