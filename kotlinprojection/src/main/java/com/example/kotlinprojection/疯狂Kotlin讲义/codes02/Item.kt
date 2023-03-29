package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * ClassName:Item
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-15
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testMapProperty()
    testDelegateFactory()
}

class Item(val map: Map<String, Any?>) {
    val barCode: String by map
    val name: String by map
    val price: Double by map
}
fun testMapProperty() {
    val item = Item(mapOf(
            "barCode" to "133355",
            "name" to "疯狂Kotlin讲义",
            "price" to 68.9
    ))
    println(item.barCode)
    println(item.name)
    println(item.price)
    println("--------------")
    //将对象持有的map暴露出来，其他程序可通过标准Map读取数据
    val map = item.map
    println(map["barCode"])
    println(map["name"])
    println(map["price"])
}

class MyTarget {
    //该属性的委托对象是providerDelegate()方法返回的MyDelegation对象
    var name: String by PropertyChecker()
}
class PropertyChecker() {
    operator fun provideDelegate(thisRef: MyTarget, prop: KProperty<*>): ReadWriteProperty<MyTarget, String> {
        //插入自定义代码，可执行任意业务操作
        checkProperty(thisRef, prop.name)
        return MyDelegation1()
    }
    private fun checkProperty(thisRef: MyTarget, name: String) {
        println("---------检查属性---------")
    }
}
class MyDelegation1: ReadWriteProperty<MyTarget, String> {
    private var _backValue = "默认值"
    override fun getValue(thisRef: MyTarget, property: KProperty<*>): String {
        println("${thisRef}的${property.name}属性执行getter方法")
        return _backValue
    }
    override fun setValue(thisRef: MyTarget, property: KProperty<*>, value: String) {
        println("${thisRef}的${property.name}属性执行setter方法,传入参数值为: ${value}")
        _backValue = value
    }
}
fun testDelegateFactory() {
    //创建对象(初始化属性),调用委托工厂的provideDelegate()方法
    val pd = MyTarget()
    //读取属性，实际上是调用属性的委托对象的getter方法
    println(pd.name)
    //写入属性，实际上是调用属性的委托对象setter
    pd.name = "fkit.org"
    println(pd.name)
}