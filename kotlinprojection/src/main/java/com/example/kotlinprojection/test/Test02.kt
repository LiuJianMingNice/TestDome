package com.example.kotlinprojection.test

/**
 * ClassName:Test02
 * Package:com.example.kotlinprojection.test
 * @date:21-6-28
 * @author:liujianming
 */
class Test02 {
    var v = "成员属性"

    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

interface  TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var test = Test02()

    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }

    })
}