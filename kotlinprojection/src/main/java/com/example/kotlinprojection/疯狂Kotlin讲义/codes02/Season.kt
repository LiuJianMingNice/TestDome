package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Season
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-14
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testEnum()
    testGender()
}

enum class Season {
    //在第一行列出4个枚举实例
    SPRING, SUMMER, FALL, WINTER
}
fun testEnum() {
    //枚举类默认有一个values()方法，返回该枚举类的所有实例
    for (s in Season.values()) {
        println(s)
    }
    val seasonName = "SUMMER"
    val s: Season = Season.valueOf(seasonName)
    println(s)
    //直接访问枚举值
    println(Season.WINTER)
}

enum class Gender(val cnName: String) {
    MALE("男"), FEMALE("女");
    //定义方法
    fun info() {
        when(this) {
            MALE -> println("天行健，君子以自强不息")
            FEMALE -> println("地势坤，君子以厚德载物")
        }
    }
}
fun testGender(){
    //通过Gender的valueOf()方法根据枚举名获取枚举值
    val g = Gender.valueOf("FEMALE")
    //访问枚举值的cnName属性
    println("${g}代表：${g.cnName}")
    //调用info方法
    g.info()
}