package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Product
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-14
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testObjectExpression()
    ObjectExprType().test()
}

interface Outputable1 {
    fun output(msg: String)
}
abstract class Product1(var price: Double) {
    abstract val name: String
    abstract fun printInfo()
}
fun testObjectExpression() {
    //指定一个父类型(接口)的对象表达式
    val ob1 = object : Outputable1{
        override fun output(msg: String) {
            for (i in 1..6){
                println("<h${i} > ${msg}</h${i}>")
            }
        }
    }
    ob1.output("疯狂软件教育中心")
    println("------------------")
    //指定零个父类型的对象表达式
    var ob2 = object {
        init {
            println("初始化快")
        }
        //属性
        var name = "Kotlin"
        //方法
        fun test() {
            println("test方法")
        }
        //只能包含内部类，不能包含嵌套类
        inner class Foo
    }
    println(ob2.name)
    ob2.test()
    println("--------------------")
    //指定两个父类型的对象表达式
    //犹豫Product只有一个带参数的构造器，因此需要传入构造器参数
    var ob3 = object : Outputable1, Product1(28.8) {
        override fun output(msg: String) {
            println("输出信息：" + msg)
        }

        override val name: String
            get() = "激光打印机"

        override fun printInfo() {
            println("高速激光打印机，支持双面自动打印!")
        }
    }
    println(ob3.name)
    ob3.output("Kotlin真不错")
    ob3.printInfo()
}

class ObjectExprType {
    private val ob1 = object  {
        val name: String = "fkit"
    }
    internal val ob2 = object {
        val name: String = "fkit"
    }
    private fun privateBar() = object {
        val name: String = "fkit.org"
    }
    fun publicBar() = object {
        val name: String = "fkit.org"
    }
    fun test() {
        //ob1是private对象表达式，编译器可识别它的真实类型
        println(ob1.name)
        //ob2是非private对象表达式，编译器当它是Any类型
//        println(ob2.name)
        //privateBar是private函数，编译器可识别它返回的对象表达式的真实类型
        println(privateBar().name)
        //publicBar是非private函数，编译器将它返回的对象表达式当成Any类型
//        println(publicBar().name)
    }

}