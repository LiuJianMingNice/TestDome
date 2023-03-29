package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

import java.lang.RuntimeException
import kotlin.Exception

/**
 * ClassName:TestThrow
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-15
 * @author:liujianming
 */

fun main(args: Array<String>) {
    //无论该异常在Java中是否为checked异常
    //在kotlin中该异常都不是checked异常
//    throwChecked(-3)
//    throwRuntime(3)

    PrintStackTraceTest().firstMethod()
}

fun throwChecked(a: Int) {
    if (a > 0) {
        //自行抛出普通异常，在kotlin中也不是checked异常
        //该代码不必处于try块中
        throw Exception("a的值大于0，不符合要求")
    }
}
fun throwRuntime(a: Int) {
    if (a > 0) {
        throw RuntimeException("a的值大于0，不符合要求")
    }
}
class TestThrow {
}

class SelfException: Exception{
    constructor() {}
    constructor(msg: String): super(msg){}
}
class PrintStackTraceTest{
    fun firstMethod() {
        secondMethod()
    }
    fun secondMethod() {
        thirdMethod()
    }
    fun thirdMethod() {
        throw SelfException("自定义异常信息")
    }
}