package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Apple
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-15
 * @author:liujianming
 */

fun main(args: Array<String>) {

//    //由于传给泛型T的是String，所以构造器的参数只能是String
//    var a1: Apple1<String> = Apple1<String>("苹果")
//    println(a1.info)
//    //由于传给泛型T的是Int，所以构造器的参数只能是Int
//    var a2: Apple1<Int> = Apple1(3)
//    println(a2.info)

    //此时T的类型是String
    var user = User3<String>("fkit")
    println(user.info)
    //对于u2而言，它的类型是User<Any>,此时T的类型是Any
    //由于程序声明了T支持协变，因此User<String>可当成User<Any>使用
    var u2: User3<Any> = user

}

//定义Apple类时使用了泛型声明
open class Apple1<T> {
    //使用泛型T定义属性
    open var info: T?
    constructor() {
        info = null
    }
    //下面方法中使用泛型T来定义构造器
    constructor(info: T) {
        this.info = info
    }
}

class User3<out T> {
    //此处不能用var，否则就有setter方法
    //setter方法会导致T出现在方法形参中
    val info: T
    constructor(info: T) {
        this.info = info
    }
    fun test(): T{
        println("执行test方法")
        return info
    }
}

fun testOut() {
    var numArr: Array<out Number> = arrayOf(2,3,4.3,1.2)
//    numArr.set(0, 3.4)
    var intArr: Array<Int> = arrayOf(2,3,4)
    numArr = intArr
}