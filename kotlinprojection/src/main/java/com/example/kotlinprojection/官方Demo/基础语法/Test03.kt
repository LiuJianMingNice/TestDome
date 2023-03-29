package com.example.kotlinprojection.官方Demo.基础语法

import android.media.session.MediaSession
import com.example.kotlinprojection.疯狂Kotlin讲义.codes02.Item

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * Test03
 * @author liujianming
 * @date 2021-11-22
 */

//fun main(args: Array<String>) {
//    val helloWorld = object {
//        val hello = "Hello"
//        val world = "World"
//        override fun toString() = "$hello $world"
//    }
//
//    println(helloWorld)
//
//    var a: String = "abc"
//
//    var b: String? = "abc"
//    b = null
//
//    val l = a.length
//}

fun main(args: Array<String>) {
//⾼阶函数调⽤时，就可以把⼀个函数加双冒号，将函数实例成⼀个对象去调⽤了。
    println(lock("param1", "param2", ::getResult))
}
/**
 * @param str1 参数1
 * @param str2 参数2
 */
fun getResult(str1: String, str2: String): String = "result is {$str1 , $str2}"
/**
 * @param p1 参数1
 * @param p2 参数2
 * @param method ⽅法名称
 */
fun lock(p1: String, p2: String,
         method: (str1: String, str2: String) -> String): String {
    return method(p1, p2)
}
