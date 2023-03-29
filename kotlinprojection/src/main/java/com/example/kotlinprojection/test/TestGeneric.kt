package com.example.kotlinprojection.test

import android.view.Window
import kotlin.properties.Delegates

/**
 * ClassName:TestGeneric
 * Package:com.example.kotlinprojection.test
 * @date:21-6-29
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    val age = 23
//    val name = "runoob"
//    val bool = true
//    doPrintln(age)
//    doPrintln(name)
//    doPrintln(bool)

//    val user = User1()
//    user.name = "第一次赋值"
//    user.name = "第二次赋值"

    val site = Site(mapOf("name" to "菜鸟教程",
                            "url" to "www.runoob.com"))
    println(site.name)
    println(site.url)

    var tests : String
    var bigValue : Long = 2999999999

}

fun <T> doPrintln(content: T) {
    when (content) {
        is Int -> println("整型数字为$content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        is Int -> println("T不是整型也不是字符串")
    }
}

class User1 {
    var name: String by Delegates.observable("初始值") {
        prop, old, new -> println("旧值：$old -> 新值：$new")
    }
}



class TestGeneric {

}

class Site(val map: Map<String, Any?>) {
    val name: String by map
    val url: String by map


}