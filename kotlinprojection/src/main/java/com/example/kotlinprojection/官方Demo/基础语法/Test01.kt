package com.example.kotlinprojection.官方Demo.基础语法

import java.lang.Exception

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * Test01
 * @author liujianming
 * @date 2021-11-10
 */
//fun main() {
//    println("你好1呀！！！！！")
//
//    val items = listOf("Apple", "Banana")
//    for (item in items.indices) {
//        println(item)
//    }
//}

fun main() {


//    val x = 10
//    val y = 9
//    if (x in 1..y+1) {
//        println("fits in range")
//    }



//    println("int==>> " + parseInt("12"))


//    val list = listOf("a", "b", "c")
//    val map = mapOf("a" to "sss", "b" to "ccc", "c" to "ddd")
//    for ((k, v) in map) {
//        println("k ==>> $k, v ==>> $v")
//    }

//    val myObject = object: MyAbstractClass(){
//        override fun doSomeThing() {
//            TODO("Not yet implemented")
//        }
//
//    }

//    var a = 1
//    var b = 2
//    println("a = $a, b = $b")
//    a = b.also { b = a }
//    println("a1 = $a, b1 = $b")

//    var x = 5L / 2
//    println("x==>> " + x)

//    val str = "abcd"
//    for (c in str) {
//        println("c==>> " + c)
//    }

//    var s = "abc" + 1
//    println(s + "def")

//    test()

    foo()
}


fun sum(a: Int, b: Int): Int{
    return a + b
}

fun sum1(a: Int, b: Int) = a + b

class Test01

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun test() {
    var x: Int = 1
    when(x) {
        in 1..10 -> println("x is in the range")
    }

    val arrays = arrayOf("a", "b", "c")
    for (i in arrays.indices) {
        println(arrays[i])
    }

    for ((index, value) in arrays.withIndex()) {
        println("index is $index, value is $value")
    }
}

fun foo() {
    listOf(1, 2, 3).forEach{
        if (it == 3) return
        println(it)
    }

    val strList = listOf<String>("a", "b", "c")
    strList.forEach {
        val str: String = "hello"
    }
    println("this point is unreachable")

    var setterVisibility: String = "abc"
}

abstract class MyAbstractClass {
    abstract fun doSomeThing()
}
