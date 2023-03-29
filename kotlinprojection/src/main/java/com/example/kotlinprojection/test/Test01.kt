package com.example.kotlinprojection.test

import java.lang.Integer.parseInt

/**
 * ClassName:Test01
 * Package:com.example.kotlinprojection.test
 * @date:21-6-25
 * @author:liujianming
 */
fun main(args: Array<String>) {
//    if (args.size < 2) {
//        print("Two integers expected")
//        return
//    }
//    val x = parseInt(args[0])
//    val y = parseInt(args[1])
//
//    if (x != null && y != null) {
//        print(x * y)
//    }

    val test01 = Test01()
//    test01.testRange()
//    test01.testArray()
//    test01.testString()
    test01.testWhen()
}
class Test01 {
    fun testRange() {
        for (i in 1..4 step 2)
            print(i)
    }

    fun check(c: Char) {
        if (c.toInt() == 2)
            print(c)
    }

    fun testArray() {
        val a = arrayOf(1, 2, 3)
        val b = Array(5, { i -> (i * 2) })

        println(a[0])
        for ((index,e) in b.withIndex())
        println("下标=$index----元素=$e")
    }

    fun testString() {
        val s = """
            Hello
            Hi
            Bob
        """.trimIndent()
        println(s)

        val a: Int = 23
        val b: Int = 12
        val max = if (a < b) a else b
    }

    fun testWhen() {
        var x = 0

        when(x) {
            0 -> println("x是0")
            1 -> println("x是1")
        }

        when(x) {
            1 -> println("x是1")
            2 -> println("x是2")
            else -> println("既不是1也不是2")
        }

        when(x) {
            in 0..10 -> println("在区间内")
            else -> println("不在区间内")
        }
    }

}