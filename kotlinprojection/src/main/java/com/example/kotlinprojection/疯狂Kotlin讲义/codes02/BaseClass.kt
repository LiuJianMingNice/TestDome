package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:BaseClass
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-12
 * @author:liujianming
 */


fun main(args: Array<String>) {
//    Sub()
//    Sub("Sub")
//    Sub("子类", 29)

    //下面编译时类型和运行时类型完全一样，因此不存在多态
    var bc: BaseClass = BaseClass("ssss")
    //输出6
    println(bc.book)
    //下面两次调用将执行BaseClass的方法
    bc.base()
    bc.test()
    //下面编译时类型和运行时类型完全一样，因此不存在多态
    var sc: SubClass = SubClass()
    //输出60
    println(sc.book)
    //下面调用将执行从父类继承的base（）方法
    sc.base()
    //下面调用将执行当前类的test（）方法
    sc.test()
    //下面编译时类型和运行时类型不一样，多态发生
    var ploymophicBc: BaseClass = SubClass()
    //输出60-->标明访问的依然是子类对象的属性
    println(ploymophicBc.book)
    //下面执行将执行从父类继承的base（）方法
    ploymophicBc.base()
    //下面调用将执行当前类的test（）方法
    ploymophicBc.test()
    //因为ploymophicBc的编译时类型是BaseClass
    //BaseClass类没有提供sub（）方法，所以下面代码编译时会出现错误
//    ploymophicBc.sub()
}

open class BaseClass {
    var name: String
    open var book = 6
    fun base() {
        println("父类的普通方法")
    }
    open fun test() {
        println("父类的被覆盖的方法")
    }
    constructor(name: String) {
        this.name = name
    }
}

class SubClass: BaseClass("ssss") {
    override var book = 60
    override fun test() {
        println("子类的覆盖父类的方法")
    }
    fun sub() {
        println("子类的普通方法")
    }
}

//子类没有显式声明主构造器
//子类默认有一个主构造器，因此要在声明继承时委托调用父类构造器
class SubClass1: BaseClass("foo") {
}

//子类有显式声明主构造器
class SubClass2(name: String): BaseClass(name) {
}

open class Base {
    constructor() {
        println("Base的无参数的构造器")
    }
    constructor(name: String) {
        println("Base的带一个String参数:${name}的构造器:")
    }
}
class Sub: Base{
    //构造器没有显式委托
    //因此该次构造器将会隐式委托调用父类无参数的构造器
    constructor() {
        println("Sub的无参数的构造器")
    }
    //构造器用Super(name)显式委托父类带String参数的构造器
    constructor(name: String): super(name) {
        println("Sub的String构造器，String参数为:${name}")
    }
    //构造器用this(name)显式委托本类中带String参数的构造器
    constructor(name: String, age: Int): this(name) {
        println("Sub的String，Int构造器，Int参数为：${age}")
    }
}

open class Foo {
    open fun test() {
        println("Foo的test")
    }
    fun foo() {
        println("foo")
    }
}

interface Bar {
    //接口中成员默认是open的
    fun test() {
        println("Bar的test")
    }
    fun bar() {
        println("bar")
    }
}
class Wow : Foo(), Bar {
    override fun test() {
        super<Foo>.test()
        super<Bar>.test()
    }
}