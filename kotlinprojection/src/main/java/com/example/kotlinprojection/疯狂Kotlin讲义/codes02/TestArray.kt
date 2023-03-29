package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:TestArray
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-1
 * @author:liujianming
 */

fun main(args: Array<String>) {
//    testWithIndex()
//    testArrayMethods()
//    testNum2Rmb()
    gobang()
}

fun createArray() {
    //创建包含指定元素的数组（相当于Java数组的静态初始化）
    var arr1 = arrayOf("Java", "Kotlin", "Swift", "Go")
    var intArr1 = arrayOf(2, 4, 500, -34)
    //创建指定长度、元素为null的数组（相当于Java数组的动态初始化）
    var arr2 = arrayOfNulls<Double>(5)
    var intArr2 = arrayOfNulls<Int>(6)
    //创建长度为0的空数组
    var arr3 = emptyArray<String>()
    var intArr3 = emptyArray<Int>()
    //创建指定长度、使用Lambda表达式初始化数组元素的数组
    var arr4 = Array(5, {(it * 2 + 97).toChar()})
    var strArr4 = Array(6, {"fkit"})
}

fun testWithIndex() {
    var books = arrayOf("轻量级Java EE企业应用实战", "疯狂Java讲义", "疯狂Android讲义")
    //通过withIndex（）方法可同时访问数组的索引和元素
    for ((index, value) in books.withIndex()) {
        println("索引为${index}的元素是：${value}")
    }
}

fun testArrayMethods() {
    //定义一个数组
    var arr = arrayOf(2, 4, 5, 6)

    //判断是有所有元素的平方都大于20
    println(arr.all({it * it > 20})) //输出false
    //判断是否任一元素的平方大于20
    println(arr.any({it * it > 20})) //输出true
    //根据数组元素来计算<K,V>对，返回所有<K,V>对组成的Map集合
    //下面的算法规则是:K是数组元素+2，V是数组元素的平方
    var result1 = arr.associate({it + 10 to it * it})
    println(result1)
    //创建一个可变Map集合，用于追加根据数据组计算出来的key-value对
    var map = mutableMapOf(1 to 100, 2 to 120, -1 to 130)
    //将计算出来的key（元素的平方）、value（元素）对添加到map集合
    arr.associateByTo(map, {it * it})
    println(map)
    //计算数组所有元素的总和
    println(arr.fold(0, {acc, e -> acc + e}))  //输出17
    //定义一个a数组
    var a = arrayOf(3, 4, 5, 6)
    //定义一个a2数组
    var a2 = arrayOf(3, 4, 5, 6)
    //a数组和a2数组的长度相等，每个元素依次相等，将输出true
    println("a数组和a2数组是否相等：${a.contentEquals(a2)}")
    //通过复制a数组，生成一个新的b数组
    var b = a.copyOf(6)
    println("a数组和b数组是够相等：${a.contentEquals(b)}")
    //输出b数组的元素，将输出[3, 4, 5, 6, null, null]
    println("b数组的元素为：${b.contentToString()}")
    //将b数组的第5个元素（包括）到第7个元素（不包括）赋值为1
    b.fill(1, 4, 6)
    //输出b数组的元素，将输出[3, 4, 5, 6, 1, 1]
    println("b数组的元素为：${b.contentToString()}")
    //对b数组进行排序
    b.sort()
    //输出b数组的元素，将输出[1, 1, 3, 4, 5, 6]
    println("b数组的元素为：${b.contentToString()}")
}

fun testNum2Rmb() {
    //测试把一个浮点数分解成整数部分和小数部分
    println(divide(236711125.123).contentToString())
    //测试把一个4位的数字字符串变成汉字字符串
    println(toHanStr("60901"))
}
fun divide(num: Double): Array<String> {
    //将一个浮点数强制类型转换为Long型，即得到它的整数部分
    var zheng = num.toLong()
    //浮点数减去整数部分，得到小数部分，小数部分乘以100后再取整得到2位小数
    var xiao = Math.round((num - zheng) * 100)
    //下面把整数转换为字符串
    return arrayOf(zheng.toString(), xiao.toString())
}
val hanArr = arrayOf("零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖")
val unitArr = arrayOf("十", "百", "千", "万")
/**
 * 把一个4位的数字字符串变成汉字字符串
 */
fun toHanStr(numStr: String): String {
    var result = ""
    val numLen = numStr.length
    var flag = false
    //依次遍历数字字符串的每一位数字
    for (i in 0 until numLen) {
        //把Char型数组转换成Int型数字，因为它们的ASCII码值恰好相差48
        //因此把Char型数字减去48得到Int型数字，例如'4'被转换成4
        println(i)
        var num = numStr[i].toInt() - 48
        //如果不是最后以为数字，而且数字不是0，则需要添加单位(千、百、十)
        println("1111====>>>>" + flag)
        if (i != numLen - 1 && num != 0) {
            result += hanArr[num] + unitArr[numLen - 2 - i]
            flag = false
        } else {
            if (numLen - 2 - i >= 0 || num != 0) {
                if (!flag) {
                    result += hanArr[num]
                    flag = true
                    println("2222====>>>>" + flag)
                }

            }
        }
    }
    return result
}


//定义棋盘的大小
val BOARD_SIZE = 15
//定义一个二维数组来充当棋盘
var board = Array(BOARD_SIZE, {Array(BOARD_SIZE, {""})})

fun initBoard() {
    //把每个元素赋为"+"，用于在控制台台面画出棋盘
    for (i in 0 until BOARD_SIZE) {
        for (j in 0 until BOARD_SIZE) {
            board[i][j] = "+"
        }
    }
}
//在控制台输出棋盘的方法
fun printBoard() {
    //打印每个数组元素
    for (i in 0 until BOARD_SIZE) {
        for (j in 0 until BOARD_SIZE) {
            //打印数组元素后不换行
            print(board[i][j])
        }
        //每打印完一行数组元素后输出一个换行符
        println()
    }
}
fun gobang() {
    initBoard()
    printBoard()
    var inputStr = readLine()
    while (inputStr != null) {
        //将用户输入的字符串以逗号(,）作为分隔符，分隔成两个字符串
        var posStrArr = inputStr.split(",")
        //将两个字符串转换成用户下棋的坐标
        var xPos = posStrArr[0].toInt()
        var yPos = posStrArr[1].toInt()
        //把对应的数组元素赋为“。”
        board[yPos - 1][xPos - 1] = "。"
        /**
         * 电脑随机生成两个整数，作为电脑下棋的坐标，赋给board数组
         * 还涉及
         * 1.坐标的有效性，只能是数字，不能超出棋盘范围
         * 2.下的棋的点，不能重复下棋
         * 3.每次下棋后，需要扫描谁赢了
         */
        printBoard()
        println("请输入您下棋的坐标，应以x，y的格式：")
        inputStr = readLine()
    }
}



class TestArray {
}