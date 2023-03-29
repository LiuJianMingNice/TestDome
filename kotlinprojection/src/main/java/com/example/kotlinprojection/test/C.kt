package com.example.kotlinprojection.test

/**
 * ClassName:C
 * Package:com.example.kotlinprojection.test
 * @date:21-6-28
 * @author:liujianming
 */
open class A {
    open fun f () { println("A")}
        fun a() { println("a") }

}
interface  B {
    fun f () { println("B") }
    fun b() { println("b")}
}
class C() : A() , B{
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}

fun main(args: Array<String>) {
    val c = C()
    c.f()
}