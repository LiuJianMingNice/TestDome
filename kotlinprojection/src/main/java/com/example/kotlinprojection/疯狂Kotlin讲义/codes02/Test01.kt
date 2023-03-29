package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Test01
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-6-30
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testInvoke()
//    testRange()
//    testRange1()
//    testData()
    testPoint()
}

fun testInvoke() {
    val s = "java.lang.String"
    //使用反射获取String类的length()方法
    val mtd = Class.forName(s).getMethod("length")
    //使用传统方法，使用Method对象的invoke()方法
    println(mtd.invoke("java"))
    //使用调用运算符
    println(mtd("java"))
}

//闭区间运算符
fun testRange() {
    //使用闭区间运算符定义区间
    var range1 = 2 .. 6
    for (num in range1) {
       println("${num} * 5 = ${num * 5}")
    }
}

fun testRange1() {
    val bookList = arrayListOf<String>("Kotlin", "Java", "Html", "C++")
    for (index in 0 until bookList.size) {
        println("第${index + 1}本书的书名是：${bookList[index]}")
    }
}

data class Data(val x: Int, val y: Int) {
    //为Data类定义一个unaryMinus()方法
    operator fun unaryMinus(): Data {
        return Data(-x, -y)
    }
}
//以扩展方法的形式为Data类定义not()方法
operator fun Data.not(): Data {
    return Data(-x, -y)
}
fun testData() {
    val d = Data(4, 10)
    println(-d)
    println(!d)
}

data class Point(val x: Int, val y: Int) {
    //为Point类定义一个minus()方法
    operator fun minus(target: Point): Double {
        return Math.hypot((this.x - target.x).toDouble(), (this.y - target.y).toDouble())
    }
}
//以扩展方法的形式为Point类定义times()方法
operator fun Point.times(target: Point): Int {
    return Math.abs(this.x - target.x) * Math.abs(this.y - target.y)
}
fun testPoint() {
    var p1 = Point(4, 10)
    var p2 = Point(5, 15)
    var distance = p1 - p2
    println("p1与p2的距离为：${distance}")
    var area = p1 * p2
    println("p1与p2围城矩形的面积为：${area}")
}

fun testWhen() {
    var score = 'B'
    when(score) {
        'A' -> println("优秀")
        'B' -> println("良好")
        'C' -> println("一般")
        'D' -> println("差")
        else -> println("太差了吧")
    }
}
class Test01 {
}