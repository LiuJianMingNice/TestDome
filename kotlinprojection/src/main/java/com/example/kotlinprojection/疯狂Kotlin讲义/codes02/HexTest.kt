package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:HexTest
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-6-30
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testValue()
//    testFloatValue()
//    testChar()
//    testTypeConversion()
    testString()
    test1("sss")
}

fun testValue() {
    //以0b或0B开头的整数数值的二进制的整数
    var binValue1 = 0b1010101
    var binValue2 = 0B10101110

    //以0x或0X开头的整数数值是十六进制的整数
    var hexValue1 = 0x13
    var hexValue2 = 0XaF
    println("binvalue1的值为：${binValue1}")
    println("binValue2的值为：${binValue2}")
    println("hexValue1的值为：${hexValue1}")
    println("hexValue2的值为：${hexValue2}")
}

fun testFloatValue() {
    var af1 = 5.2345556f
    //下面将看到af1的值已经发生了改变
    println("af1的值为：${af1}")
    //声明af2是Float类型，但25.2345默认是Double类型，因此小面代码编译时报错
    var af2: Float = 25.2345F
    //f1的类型呗推断为Double
    var f1 = 5.12e2
    println("f1的值为：${f1}")
    var a = 0.0
    //5.0除以0.0将出现正无穷大
    println("5.0/a的值为：${5.0 / a}")
    //所有的正无穷大数值都相等，所以下面将会输出true
    println(5.0 / a == 50000 / 0.0)
    //-5.0除以0.0将出现负无穷大数值
    println("-5.0 / a的值为：${-5.0 / a}")
    //所有的负无穷大数值都相等，所以下面将会输出true
    println(-5.0 / a == -50000 / 0.0)
    //0.0除以0.0将出现非数
    var nan : Double = a / a
    println("a/a的值为：${nan}")
    //非数与自己都不相等，所以下面将会输出false
    println(nan == nan)
}

fun testChar() {
    //直接指定单个字符作为字符值
    val aChar: Char = 'a'
    //使用转义字符来作为字符值
    val enterCharSequence: Char = '\r'
    //使用Unicode编码值来指定字符值
    val ch: Char = '\u9999'
    //将输出一个'香'字符
    println(ch)
    //定义一个'疯'字符值
    var zhong: Char = '疯'
    //将Char型变量当成Int型处理会报错
//    var zhongValue: Int = zhong
}

fun testTypeConversion() {
    var bookPrice : Byte = 79
    var itemPrice : Short = 120
    //bookPrice是Byte类型，但变量a是short类型，因此下面代码错误
//    var a: Short = bookPrice
    //显式将bookPrice强制转换为Short类型
    var a: Short = bookPrice.toShort()
    var b: Byte = itemPrice.toByte()
    println("a: ${a}, b: ${b}")
    val amount = 233
    //将Int型变量转换为Byte类型，发生溢出
    val byteAmount: Byte = amount.toByte()
    println(byteAmount)
}

fun testFloatConverseInt (){
    var width: Float = 2.3f
    var height: Double = 4.5
    //width必须显式强制转换为Double之后，才能复制给变量a
    var a: Double = width.toDouble()
    println("a的值为：${a}")

    //将height强制转换为Float之后再进行计算整个表达式的类型是Float
    //因此ara1的类型也被推断为Float
    var area1 = width * height.toFloat()
    //表达式中的height是Double类型，它是等级最高的运算数
    //因此整个表达式的类型是Double，area2的类型也被推断为Double
    var area2 = width * height
    val multi: Int = 5
    //因此totalHeight1的类型也被推断为Double
    var totalHeight1 = height * multi
    //将height强制转换为Int类型后进行计算，整个表达式的类型是Int
    //因此totalHeight2的类型也被推断为Int
    var totalHeight2 = height.toInt() * multi
}

fun test() {
    var i = 1
    var boolean: Boolean = true
    if (boolean) {

    }

    var str = "hhh"
    var num : Int? = str.toIntOrNull()

    var aStr : String = "fkit"
    var bStr : String? = "fkit"
//    aStr = null
    bStr = null
}

fun testElvis() {
    var b : String? = "fkit"
    //先判断b不为null，然后访问b的length属性
    var len1 = if (b != null) b.length else -1
    println(len1)
    b = null
    //使用Elvis运算符
    var len2 = b?.length ?: -1
    println(len2)
}

fun testString() {
    //定义普通字符串
    var str = "fkjava.org"
    println(str.length)
    //定义原始字符串
    val txt = """
        ^天上白玉亭，
        ^十二楼五城。
        ^仙人抚我顶，
        ^结发受长生。
    """.trimMargin("^")
    println(txt)
}

fun test1(str: String) {
    var str = "fkjava.org"
    var list = ArrayList<String>()
    list.add("Java")
    list.add("Kotlin")
    list.add("Go")
}

class HexTest {
}