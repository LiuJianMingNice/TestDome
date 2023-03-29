package com.example.kotlinprojection.疯狂Kotlin讲义.codes02

/**
 * ClassName:Raw
 * Package:com.example.kotlinprojection.疯狂Kotlin讲义.codes02
 * @date:21-7-13
 * @author:liujianming
 * 一日清晨，大雾散去，不止清晨，不止大雾
 */

fun main(args: Array<String>) {
//    var t = Raw()
//    t.test()
//    //调用Raw对象扩展的方法
//    t.info()
//    //创建Raw类的子类的实例
//    var rs = RawSub()
//    rs.test()
//    rs.sub()
//    //Raw的子类的对象也可调用扩展的方法
//    rs.info()

//    var nums = listOf(20, 30, 100, 34, 67)
//    //调用程序为List扩展的shuffle()方法
//    println(nums.shuffle())
//    println(nums.shuffle())
//    var strings = listOf("java", "kotlin", "c++", "javascript")
//    println(strings.shuffle())
//    println(strings.shuffle())

//    var user1 = User1("悟空", "孙")
//    println(user1.fullName)
//    user1.fullName = "八戒.猪"
//    println(user1.first)
//    println(user1.last)

    var sub2 = Sub2()
    sub2.test()
    println(sub2.name)
}

open class Raw {
    fun test() {
        println("test方法")
    }
}

class RawSub : Raw() {
    fun sub() {
        println("--sub()方法--")
    }
}

fun Raw.info() {
    println("===扩展的info方法===")
}

//该方法的实现思路是：先生成List集合所有索引的随机排列
//然后根据随机排列的索引去List集合取元素
fun<T> List<T>.shuffle(): List<T> {
    val size = this.size
    //下面的indexArr用于保证List集合的索引的随机排列
    var indexArr = Array(size, {0})
    var result: MutableList<T> = mutableListOf()
    //创建随机对象
    val rand = java.util.Random()
    var i = 0
    outer@ while (i < size) {
        //生成随机数
        var r = rand.nextInt(size)
        for (j in 0 until i) {
            //如果r和前面已生成的任意数字相等，则该随机数不可用，需要重新生成
            if (r == indexArr[j]) {
                continue@outer
            }
        }
        //如果上面的循环结束了都没有执行continue，则说明该r是一个不重复的随机数
        //将随机数r存入indexArr数组中
        indexArr[i] = r
        //根据随机的索引读取List集合元素，并将元素添加到result集合中
        result.add(this[r])
        i++
    }
    return result.toList()
}

class User1(var first:String, var last:String) {
}

//为User扩展读写属性
var User1.fullName: String
    get() = "${first}.${last}"
    set(value) {
        println("执行扩展属性fullName的setter方法")
        //value字符串中不包含.或包含几个.都不行
        if ("." !in value || value.indexOf(".") != value.lastIndexOf(".")) {
            println("您输入的fullName不合法")
        } else {
            var tokens = value.split(".")
            first = tokens[0]
            last = tokens[1]
        }
    }

open class FinalPropertyTest {
    //kotlin自动为该属性添加final修饰
    var test: String = "测试属性"
}
class Sub1: FinalPropertyTest() {
    //下面的属性定义将出现编译错误，不能重写final属性
//    override var test: String = "子类属性"
}

open class PrivateFinalMemberTest {
    private final fun test() {
        println("父类test()方法")
    }
    private final var name: String = "父类属性"
}

class Sub2: PrivateFinalMemberTest() {
    public fun test() {
        println("子类test()方法")
    }
    public var name: String = "子类属性"
}

