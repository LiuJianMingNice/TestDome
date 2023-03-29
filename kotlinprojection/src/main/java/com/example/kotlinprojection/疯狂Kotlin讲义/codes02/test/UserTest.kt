package com.example.kotlinprojection.疯狂Kotlin讲义.codes02.test

/**
 * ClassName:UserTest
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02.test
 * @date:21-7-17
 * @author:liujianming
 */

fun main(args: Array<String>) {
    val user = User()
    //操作name读写属性
    user.name = "yeeku"
    println(user.name)
    //操作isMarried读写属性
    user.isMarried = true
    println(user.isMarried)
    //读取age只读属性
    println(user.age)
}

class UserTest {
}