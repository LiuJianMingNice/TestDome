package com.example.kotlindome1.test1

import java.io.File
import java.lang.StringBuilder
import java.util.concurrent.locks.Lock

/**
 * Copyright (c) 2022 Raysharp.cn. All rights reserved.
 *
 * Test01
 * @author liujianming
 * @date 2022-09-07
 */
class Test01 {


}

val sum = { x: Int, y: Int -> x + y }
val action = { println(42) }

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

//fun main(arg: Array<String>) {
////    twoAndThree { a, b -> a + b }
////    twoAndThree { a, b -> a * b }
//
//    //变量的类型是一个匿名函数
//    val blessingFunction:()->String
//    blessingFunction = {
//        val holiday = "National Day."
//        "Happy $holiday"
//    }
//    println(blessingFunction())
//}

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun foo(l: Lock) {
    println("Before sync")
    synchronized(l) {
        println("Action")
    }
    println("After sync")
}


//

fun test01() {
    val getDiscountWords = { goodsName: String, hour: Int ->
        val currentYear = 2027
        "${currentYear}年，双11${goodsName}促销倒计时: $hour 小时"
    }
}

//具名函数
//fun showOnBoard(goodsName: String, showDiscount::(String, Int)->String) {
//    val hour = (1..24).shuffled().last()
//    println(showOnBoard())
//}

fun main(arg: Array<String>) {
//    testCheckNotNull()
//    testSubString()
//    testSplit()
//    testReplace()
//    testEqual()
//    testForEach()
    testObject()
}

fun testCheckNotNull() {
    var number: Int? = null
    number = 5
    try {
        checkOperation(number)
        println(number!!.plus(1))
    } catch (e: Exception) {
        println(e)
    }
}

fun checkOperation(number: Int?) {
    checkNotNull(number, { "Something error" })
}

const val NAME = "Jimmy's friend"
fun testSubString() {
    val index = NAME.indexOf('\'')
    val str = NAME.substring(0 until index)
    println(str)
}

const val NAMES = "jack,jacky,jason"
fun testSplit() {
    val data: List<String> = NAMES.split(',')
    val (origin, dest, proxy) = NAMES.split(',')
    println("$origin $dest $proxy")
}

fun testReplace() {
    val str1 = "The people's Republic of China."
    val str2: String = str1.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "8"
            "e" -> "6"
            "i" -> "9"
            "o" -> "1"
            "u" -> "3"
            else -> it.value
        }
    }
    println(str1)
    println(str2)
}

fun testEqual() {
    val str1 = "Jason"
    val str2 = "Jason".replaceFirstChar { it.uppercase() }
    println("$str1, $str2")
    println(str1 == str2)
    println(str1 === str2)
}

fun testForEach() {
    val str1 = "The people's Republic of China.".forEach {
        print("$it *")
    }
}

fun testMap() {
    val map = mapOf("Jack" to 20, "Jason" to 18, "Jacky" to 30)
    println(map["Jack"])
}

class Player() {
    val blood = 100

    init {
        val bloodBonus = blood.times(4)
    }
}

object ApplicationConfig {
    init {
        println("loading config ...")
    }

    fun setSomething() {
        println("setSomething")
    }
}

fun testObject() {
    ApplicationConfig.setSomething()
    println(ApplicationConfig)
    println(ApplicationConfig)
}

open class ConfigMap {
    companion object {
        private const val PATH = "xxx"
        fun load() = File(PATH).readBytes()
    }
}
