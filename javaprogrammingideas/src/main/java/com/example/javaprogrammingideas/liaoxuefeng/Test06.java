package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import androidx.annotation.RequiresApi;

/**
 * ClassName:Test06
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-21
 * @author:liujianming
 */
public class Test06 {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        test1();
//        testNaturals();
//        testReduce();
//        testGroupByLetter();
//        testGroupStudentByGradeId();
        testStreamOperation();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void test1() {
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Alice");
        names.add("Tim");
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Person5> person = integers.stream().map(Person5::new).collect(Collectors.toList());
        List<Person5> persons = names.stream().map(Person5::new).collect(Collectors.toList());
        System.out.println(person);
        System.out.println(persons);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testNaturals() {
        List.of("APPLE", "BANANA", "ORANGE", "PEAR")
                .stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testReduce() {
        int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).reduce(0, (acc, n) -> acc + n);
        Stream<Integer> stream = Stream.of(1, 2, 3);
        stream.reduce(0, (acc, n) -> acc + n);
        String string = Stream.of("Hello", "World", "!").reduce("", (acc, s) -> acc + " " + s);
        System.out.println(sum);
        System.out.println(string);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testGroupByLetter() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Blackberry");
        list.add("Coconut");
        list.add("Avocado");
        list.add("Cherry");
        list.add("Apricots");

        Map<String, List<String>> groups = list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 2), Collectors.toList()));
        System.out.println(groups);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testGroupStudentByGradeId() {
        List<Student3> studentList = new ArrayList<>();
        studentList.add(new Student3(5, 1, "Bob", 78));
        studentList.add(new Student3(6, 1, "Amy", 76));
        studentList.add(new Student3(5, 2, "Alice", 86));
        studentList.add(new Student3(6, 2, "Tom", 83));
        studentList.add(new Student3(5, 3, "Tim", 70));
        studentList.add(new Student3(6, 3, "John", 84));
        studentList.add(new Student3(6, 4, "Mike", 77));
        System.out.println(studentList.toArray().toString());

        Map<Integer, List<Student3>> studentListMap = studentList.stream()
                .collect(Collectors.groupingBy(student -> student.getGradeId(), Collectors.toList()));
        System.out.println(studentListMap);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void testStreamOperation() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Orange");
        stringList.add("apple");
        stringList.add("Banana");
        stringList = stringList.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println("stringList===>>> " + stringList.toString());

        List<String> letterList = new ArrayList<>();
        letterList.add("A");
        letterList.add("B");
        letterList.add("A");
        letterList.add("C");
        letterList.add("B");
        letterList.add("D");
        letterList = letterList.stream().distinct().collect(Collectors.toList());
        System.out.println("letterList===>>> " + letterList);

        List<String> skipList = new ArrayList<>();
        skipList.add("A");
        skipList.add("B");
        skipList.add("C");
        skipList.add("D");
        skipList.add("E");
        skipList.add("F");
        skipList = skipList.stream().skip(2).limit(3).collect(Collectors.toList());
        System.out.println("skipList===>>> " + skipList);
    }
}

class Person5 {
    String name;
    int age;

    public Person5(String name) {
        this.name = name;
    }

    public Person5(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student3 {
    int gradeId;
    int classId;
    String name;
    int score;

    public Student3(int gradeId, int classId, String name, int score) {
        this.gradeId = gradeId;
        this.classId = classId;
        this.name = name;
        this.score = score;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "gradeId=" + gradeId +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
