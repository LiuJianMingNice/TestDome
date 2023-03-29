package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

import java.util.*

/**
 * ClassName:GenericExtendFunction
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-16
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testGeneric()
    testFindData()
}

class GenericExtendFunction {
}

fun <T> T.toBookString(): String {
    return "《${this.toString()}》"
}

fun testGeneric() {
    val a = 2
    //显式指定泛型函数的T为Int类型
    println(a.toBookString<Int>())
    //不显式指定你泛型函数的T的类型，系统推断出T为Double类型
    println(3.4.toBookString())
    val str = "疯狂Kotlin讲义"
    //不显式指定泛型函数的T的类型，系统推断出T为String类型
    println(str.toBookString())
}

val db = listOf("Java", Date(), 103, 2.3, '我')
fun <T> findData(clazz: Class<T>): T? {
    for (ele in db) {
        if (clazz.isInstance(ele)) {
            return (ele as? T)!!
        }
    }
    return null
}
fun testFindData() {
    println(findData(Integer::class.java))
    println(findData(java.lang.Double::class.java))
}

//使用reified修饰泛型形参，使之成为具体化的类型参数
inline fun <reified T> findData(): T?{
    for (ele in db) {
        //在函数中直接使用Ｔ作为普通类型
        if (ele is T) {
            return ele
        }
    }
    return null
}

class Apple2<T: Number> {
    var col: T
    constructor(col: T) {
        this.col = col
    }
}
fun testApple2() {
    //显式指定泛型函数的Ｔ是Int类型
    var ai = Apple2<Int>(2)
    //显式指定泛型函数的T是Double类型
    var ad: Apple2<Double> = Apple2(3.3)
    //下面代码将引发编译异常。下面代码试图把String类型传给T形参
    //但String不是Number的子类型，所以引起编译错误
//    var ap: Apple2<String> = Apple2("Kotlin")
}

