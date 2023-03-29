package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:User
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-12
 * @author:liujianming
 */

fun main(args: Array<String>) {
    var user = User("悟空", "孙")
    //输出user.fullName,实际上是调用其getter方法返回值
    println(user.fullName)
}
class User(first: String, last: String) {
    var first:String = first
    var last:String = last
    val fullName: String
    //自定义getter方法
    get() {
        println("执行fullName的getter方法")
        return "${first}.${last}"
    }
}