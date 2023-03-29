package com.example.kotlinprojection.官方Demo.基础语法

import com.example.kotlinprojection.疯狂Kotlin讲义.codes02.MyObject2.test


/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * Test02
 * @author liujianming
 * @date 2021-11-18
 */
class Test02

class Person(var gender: Gender) {
    var name = "Paul"
        set(value) {
//        println("执行，value的值为$value")
//        this.name = value
            field = when (gender) {
                Gender.MALE -> "Jake.$value"
                Gender.FEMALE -> "Rose.$value"
            }
        }
}

enum class Gender {
    MALE,
    FEMALE
}

class Test {
    private var _table: Map<String, Int>? = null
    val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("set to null by another thread")
        }
}

//fun main(args: Array<String>) {
//    //性别：MALE
//    var person = Person(Gender.MALE)
//    person.name = "Love"
//    println("name===>>> ${person.name}")
//    //性别：FEMALE
//    var person2 = Person(Gender.FEMALE)
//    person2.name = "Love"
//    println("name===>>> ${person2.name}")
//}

interface MyInterface {
    val prop: Int

    val propertyWithImplementation: String
    get() = "foo"
    fun foo() {
        println(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}

interface Named {
    val name: String
}

interface Person1 : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
        override val firstName: String,
        override val lastName: String
) : Person1

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate {
    it % 2 == 0
}

fun testLazy() {
    val list = listOf(1, 2, 3, 4).asSequence()
    val result = list.map { i->
        i * 2
    }.filter { i->
        print("Filter$i")
        i % 3 == 0
    }
    println(result.first())
}

fun main() {
//    println("Is 7 even? - ${isEven.accept(7)}")

//    testLazy()
//    val str: String? = "Hello"
//    var length: Int = str?.length?: -1

    val hangZhou = HangZhou()
    hangZhou.test()
}

interface China {
    val name: String
}

interface ZheJiang: China {
    val allName: String
    val easyName: String
    override val name: String
    get() = "$allName $easyName"
}

class HangZhou: ZheJiang {
    override val allName: String
        get() = "浙江"
    override val easyName: String
        get() = "浙"
    fun test() {
        println(name)
    }
}

