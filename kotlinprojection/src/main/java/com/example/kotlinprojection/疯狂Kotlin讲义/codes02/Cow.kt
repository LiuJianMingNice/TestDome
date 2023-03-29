package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Cow
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-14
 * @author:liujianming
 */

fun main(args: Array<String>) {

//    val cow = Cow(378.9)
//    cow.test()

//    DiscernVariable().test()

//    var aObj = A()
//    println("程序创建的A对象：${aObj}")
//    aObj.testA()

    //执行下面代码，只创建了外部类对象，还未创建内部类对象
//    val ot = Outer()
//    ot.accessInnerProp()

    runnableTest()
}

//通过主构造器为外部类定义属性
class Cow(var weight: Double = 0.0) {
    //定义一个内部类(用inner修饰，相当于Java的费静态内部类)
    //通过主构造器为内部类定义属性
    private inner class CowLeg(var length:Double = 0.0, var color: String = "") {
        //内部类的方法
        fun info() {
            println("当前牛腿颜色是：${color}, 高：${length}")
            //直接访问外部了的private修饰的foo（）方法
            foo()
        }
    }

    fun test() {
        val cl = CowLeg(1.12, "黑白相间")
        cl.info()
    }
    private fun foo() {
        println("Cow的foo方法")
    }
}

class DiscernVariable {  //隐式标签@DiscernVariable
    private val prop = "外部类的属性"
    inner class InClass {  //隐式标签@InClass
        private val prop = "内部类的属性"
        fun info() {
            val prop = "局部变量"
            //通过外部类类名.this.varname访问外部类的属性
            println("外部类的属性值：${this@DiscernVariable.prop}")
            //通过this.varName访问内部类的属性
            println("内部类的属性值：${this.prop}")
            //直接访问局部变量
            println("局部变量的值：${prop}")
        }
    }
    fun test() {
        val ic = InClass()
        ic.info()
    }
}

class A {  //隐式标签@A
    inner class B {  //隐式标签@B
        //为Int扩展foo（）方法
        fun Int.foo() {  //隐式标签@foo
            val a = this@A  //A的this
            val b = this@B  //B的this
            val c = this //不带标签的this。默认代表该方法所属对象：Int对象
            val c1 = this@foo  //显式指定@foo标签，与c代表的对象相同
            println(a)
            println(b)
            println(c)
            println(c1)
            //为String扩展funLit（）方法
            val funLit = lambda@ fun String.() {
                val d = this  //不带标签的this，默认代表该方法所属对象：String对象
                val d1 = this@lambda  //显式指定@labda标签，与d代表的对象相同
                println(d)
                println(d1)
            }
            "fkit".funLit()
            //直接定义一个Lambda表达式，没有接收者
            val funLit2 = {
                //该this所在的Lambda表达式没有接收者，因此当前范围没有this
                //系统会继续向该Lambda表达式所在范围搜索this
                //故此处this将代表foo（）方法的接收者：Int对象
                val e = this
                val el = this@foo  //显示指定@foo标签，与e代表的对象相同
                println("foo()方法中Lambda表达式的this： " + e)
                println("el的this： " + el)
            }
            funLit2()
        }
        fun testB() {
            //调用2(Int值)的foo（）方法
            2.foo()
        }
    }
    fun testA() {
        var bObj = B()
        println("程序创建的B对象：${bObj}")
        bObj.testB()
    }
}

class Outer {
    private val outProp = 9
    inner class Inner {
        val inProp = 5
        fun accessOuterProp() {
            //内部类可以直接访问外部类的private属性
            println("外部类的outProp值:${outProp}")
        }
    }
    fun accessInnerProp() {
        //外部类不能直接访问内部类的属性
        //下面代码出现编译错误
//        println("内部类的inProp值：${inProp}")
        //如需访问内部类的属性，必选显示创建内部类对象
        println("内部类的inProp值：${Inner().inProp}")
    }
}

class NestedClassTest {
    var prop1 = 5
    fun test() {
        println("外部类的test()方法")
    }
    //没有inner修饰符，是嵌套类(相当于Java的静态内部类)
    class NestedClass{
        fun accessOuterMember() {
            //访问另一个嵌套类是允许的
            val a = A()
            //下面两行代码都会出现错误
//            println(prop1)
//            test()
        }
    }
    class A
}

fun runnableTest() {
    //使用Lambda表达式创建Runnable实例
    var t = Runnable {
        for (i in 0..10) {
            println("${Thread.currentThread().getName()}, i: ${i}")
        }
    }
    //启动新线程
    Thread(t).start()
    //主线程的循环
    for (i in 0..10) {
        println("${Thread.currentThread().getName()}, i: ${i}")
    }
}
