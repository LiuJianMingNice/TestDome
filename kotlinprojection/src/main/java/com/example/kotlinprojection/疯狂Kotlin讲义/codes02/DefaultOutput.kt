package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

import kotlin.reflect.KProperty

/**
 * ClassName:DefaultOutput
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-14
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testEntrust()
    testMyDelegation()
}

interface Outputable3 {
    fun output(msg: String)
    var type: String
}
//定义一个DefaultOutput类实现Outputable接口
class DefaultOutput: Outputable3 {
    override fun output(msg: String) {
        for (i in 1..6) {
            println("<h${i}>${msg}</h${i}>")
        }
    }
    override var type: String = "输出设备"
}
//定义Printer类，指定构造参数b作为委托对象
class Printer1(b: DefaultOutput): Outputable3 by b
//定义Projector类，指定新建的对象作为委托对象
class Projector(): Outputable3 by DefaultOutput() {
    override fun output(msg: String) {
        println("msg===>>${msg}")
    }
}
fun testEntrust() {
    val output = DefaultOutput()
    //Printer对象的委托对象是output
    var printer = Printer1(output)
    //其实就是调用委托对象的output()方法
    printer.output("fkit.org")
    //其实就是调用委托对象的type属性方法
    println(printer.type)
    //Projector对象的委托对象也是output
    var projector = Projector()
    //Projector本身重写了output()方法，所以此处是调用本类重写的方法
    projector.output("疯狂软件教育中心")
    //其实就是调用委托对象的type属性方法
    println(projector.type)
}

class PropertyDelegation{
    //该属性的委托对象是MyDelegation
    var name: String by MyDelegation()
//    var name: String = "nihaoya"
}
class MyDelegation {
    private var _backValue = "默认值"
    operator  fun getValue(thisRef: PropertyDelegation, property: KProperty<*>) : String {
        println("${thisRef}的${property.name}属性执行getter方法")
        return _backValue
    }
    operator fun setValue(thisRef: PropertyDelegation,property: KProperty<*>, newValue: String) {
        println("${thisRef}的${property.name}属性执行setter方法" +
                "，传入参数值为：${newValue}")
        _backValue = newValue
    }
}
fun testMyDelegation() {
    val pd = PropertyDelegation()
    //读取属性，实际上是调用属性的委托对象的getter方法
    println(pd.name)
    //写入属性，实际上是调用属性的委托对象的setter方法
    pd.name = "fkit.org"
    println(pd.name)
}