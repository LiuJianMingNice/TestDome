package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Triangle
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-13
 * @author:liujianming
 */

fun main(args: Array<String>) {
    //使用Apple声明变量，用子类实例赋值
//    var ap1: Apple = RedFuji()
//    var ap2: Apple = Gala(2.3)
//    ap1.taste()
//    ap2.taste()

    //创建一个Printer对象，当成Output使用
    var o: Outputable = Printer()
    o.getData("轻量级Java EE企业应用实战")
    o.getData("疯狂Java讲义")
    o.out()
    o.getData("疯狂Android讲义")
    o.getData("疯狂Ajax讲义")
    o.out()
    //调用Outputable接口中定义的非抽象方法
    o.print("孙悟空", "猪八戒", "白骨精")
    o.test()
    //创建一个Printer对象，当成Product使用
    val p: Product = Printer()
    println(p.getProduceTime())
    //所有接口类型的引用变量都可以直接赋给Any类型的变量
    val obj: Any = p

}

//定义一个密封类，其实就是抽象类
sealed class Apple {
    abstract fun taste()
}
open class RedFuji: Apple() {
    override fun taste() {
        println("红富士苹果香甜可口")
    }
}

data class Gala(var weight: Double): Apple() {
    override fun taste() {
        println("嘎啦苹果更清脆，重量为：${weight}")
    }
}
class Triangle(){
}

interface Outputable {
    //只读属性定义了getter方法，非抽象属性
    val name: String
        get() = "输出设备"
    //只读属性没有定义getter方法，抽象属性
    val brand: String
    //读写属性没有定义getter、setter方法，抽象属性
    var category: String
    //接口中定义的抽象方法
    fun out()
    fun getData(msg: String)
    //在接口中定义的非抽象方法，可使用private修饰
    fun print(vararg msgs: String) {
        for (msg in msgs) {
            println(msg)
        }
    }
    //在接口中定义的非抽象方法，可使用private修饰
    fun test() {
        println("接口中test()方法")
    }
}

//定义一个Product接口
interface Product {
    fun getProduceTime(): Int
}
const val MAX_CACHE_LINE = 10
//让Private类实现Outputable和Product接口
class Printer: Outputable, Product{
    private val printData = Array<String>(MAX_CACHE_LINE, {""})
    //用以记录当前需打印的作业数
    private var dataNum = 0
    //重写接口的抽象只读属性
    override val brand: String = "HP"
    override var category: String = "输出外设"

    override fun out() {
        //只要还有作业，就继续打印
        while (dataNum > 0) {
            println("打印机打印: " + printData[0])
            //把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum)
        }
    }

    override fun getData(msg: String) {
        if (dataNum >= MAX_CACHE_LINE) {
            println("输出队列已满，添加失败")
        } else {
            //把打印数据添加到队列里，已保存数据的数量加1
            printData[dataNum++] = msg
        }
    }

    override fun getProduceTime(): Int {
        return 45
    }
}

interface InterfaceA {
    val propA: Int
        get() = 5
    fun testA()
}
interface InterfaceB {
    val propB: Int
        get() = 6
    fun testB()
}
interface  InterfaceC: InterfaceA, InterfaceB {
    val propC: Int
        get() = 7
    fun testC()
}

