package com.example.kotlindome1.test1

/**
 * Copyright (c) 2023 Raysharp.cn. All rights reserved.
 *
 * Person
 * @author liujianming
 * @date 2023-01-05
 */
class Person(var name: String, var age: Int = 0, var city: String = "") {
    fun test() {
        println("666")
    }
}

fun main() {
    val adam = Person("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)
}

class Dog {
    fun testDog() = println("dog")
}

class Cat {
    var dog: Dog? = null
    fun testCat() = println("cat")
}