package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:FunctionTest
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-5
 * @author:liujianming
 */

fun main() {
//    var x = fn(2)
//    println("x===>>> " + x)

//    printTriangle(6, '@')
//    printTriangle(7, char='#')
//    printTriangle(char = '*')

//    var data = arrayOf(3, 4, 9, 5, 8)
//    println("原始数据：${data.contentToString()}")
//    //计算元素数组的平方
//    println(map(data, ::square).contentToString())
//    //计算元素数组的立方
//    println(map(data, ::cube).contentToString())
//    //计算元素数组的阶乘
//    println(map(data, ::factorial).contentToString())

//    println(test("hello", ::printlnString1))
//    println(test("hi", ::printlnString2))

    //调用mathFunc()，程序返回一个(Int)->Int类型的函数
//    var mathFunc = getMathFunc("cube")  //得到cube函数
//    println(mathFunc(5))
//    mathFunc = getMathFunc("square")  //得到cube函数
//    println(mathFunc(5))
//    mathFunc = getMathFunc("other")  //得到cube函数
//    println(mathFunc(5))

//    tailLambda()

    //将Lambda表达式放在圆括号后面，无须使用命名参数
    var list1 = tailLambda("Java", "Kotlin", "Go"){
        it.length
    }
    println(list1)
    //将Lambda表达式放在圆括号后面，无须使用命名参数
    var list2 = tailLambda("Java", "Kotlin", "Go"){
        "疯狂${it}讲义"
    }
    println(list2)
}

fun max(x: Int, y: Int): Int {
    return if (x > y) x else y
}

fun min(x: Int, y: Int) {
    var z = if (x > y) x else y
}

fun fn(n: Int) : Int {
    if (n == 20) {
        return 1
    } else if (n == 21) {
        return 4
    } else {
        //在函数中调用它自身，就是函数递归
        return fn(n + 2) - 2 * fn (n + 1)
    }
}

fun printTriangle(height: Int = 5, char: Char) {
    for (i in 1..height) {
        //打印一排空格
        for (j in 0 until height - 1) {
            print("")
        }
        //打印一排特殊字符
        for (j in 0 until 2 * i -1) {
            print(char)
        }
        println()
    }

}

fun map(data : Array<Int>, fn: (Int) -> Int) : Array<Int> {
    var result = Array<Int>(data.size, {0})
    //遍历data数组的每个元素，并用fn函数对data[i]进行计算
    //然后将计算结果作为新数组的元素
    for (i in data.indices) {
        result[i] = fn(data[i])
    }
    return result
}
//定义一个计算平方的函数
fun square(n: Int) : Int {
    return n * n
}
//定义一个计算立方的函数
fun cube(n: Int): Int {
    return n * n * n
}
//定义一个计算阶乘的函数
fun factorial(n : Int) : Int {
    var result = 1
    for (index in 2 .. n) {
        result *= index
    }
    return result
}

fun test(s1: String, fn: (String) -> String){
    var si =  fn(s1)
}

fun printlnString1(s: String) : String{
    return s + "1"
}

fun printlnString2(s: String) : String{
    return s + "2"
}

//定义函数，该函数的返回值类型为(Int) -> Int
fun getMathFunc(type: String): (Int) -> Int {
    //定义一个计算平方的局部函数
    fun square(n: Int) : Int {
        return n * n
    }
    //定义一个计算立方的局部函数
    fun cube(n: Int) : Int {
        return n * n * n
    }
    //定义一个计算阶乘的局部函数
    fun factorial(n: Int) : Int {
        var result = 1
        for (index in 2 .. n) {
            result *= index
        }
        return result
    }
    when(type) {
        //返回局部函数
        "square" -> return ::square
        "cube" -> return ::cube
        else -> return ::factorial
    }
}

fun tailLambda() {
    var list = listOf("Java", "Kotlin", "Go")
    //最后一个参数是Lambda表达式,可将表达式写在圆括号外面
    var rt = list.dropWhile { it.length > 3 }
    println(rt)
    var map = mutableMapOf("疯狂Android讲义" to 56)
    //最后一个参数是Lambda表达式，可将表达式写在圆括号外面
    list.associateTo(map) {"疯狂${it}讲义" to it.length}
    println(map)
    //最后一个参数是Lambda表达式，可将表达式写在圆括号外面
    var rtx = list.reduce() {acc, e -> acc + e}
    println(rtx)
}

fun <T> tailLambda(vararg names: String, transform: (String) -> T) : List<T> {
    var mutableList: MutableList<T> = mutableListOf()
    for (name in names) {
        mutableList.add(transform(name))
    }
    return mutableList.toList()
}

class FunctionTest {
}