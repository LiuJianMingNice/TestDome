package com.example.kotlinprojection.test

/**
 * ClassName:Student
 * Package:com.example.kotlinprojection.test
 * @date:21-6-28
 * @author:liujianming
 */
open class Person1(var name : String, var age : Int) {

}
class Student(name : String, age : Int, var no : String, var score : Int) : Person1(name, age) {
}

fun main(args: Array<String>) {
    val s = Student("Runoob", 18, "S123456", 89)
    println("学生名：${s.name}")
    println("年龄：${s.age}")
    println("学生号：${s.no}")
    println("成绩：${s.score}")
}