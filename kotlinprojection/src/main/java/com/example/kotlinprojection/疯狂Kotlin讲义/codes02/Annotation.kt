package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Annotation
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-16
 * @author:liujianming
 */

fun main(args: Array<String>) {
    println("ssssss")
}

annotation class MyTag(val name: String, val age: Int)
annotation class ShowTag(val message: String, val target: MyTag)

class Item1 {
    //使用带属性的注解时需要为属性指定属性值
    @MyTag(name="xx", age=6)
    fun info() {
        println()
    }
}

@ShowTag("message属性值", target = MyTag(name="yeeku", age=36))
class Circle

class Annotation {
}