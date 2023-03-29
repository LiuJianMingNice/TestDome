package com.example.kotlinprojection.test

/**
 * ClassName:Hello
 * Package:com.example.kotlinprojection.test
 * @date:21-6-23
 * @author:liujianming
 */
fun main(args: Array<String>) {
//    println("Hello World!")


//    val hello = Hello();
//    hello.test("LinBiHua")

//    vars(1,2,3)

//    val sunLambda: (Int, Int) -> Int = {x, y -> x + y}
//    print(sunLambda(1,2))

    var a = 1
    val s1 = "a is $a"
    println("s1=" + s1)
    a = 2
    val s2 = "${s1.replace("is", "was")},but now is $a"
    println("s2=" + s2)
}

fun vars(vararg v: Int){
    for (vt in v){
        print(vt)
    }
}
class Hello {
    var name: String = ""
    fun test(name: String) {
        this.name = name
        println("name==>>> " + name)
    }
}