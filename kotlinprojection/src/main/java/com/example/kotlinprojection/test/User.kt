package com.example.kotlinprojection.test

/**
 * ClassName:User
 * Package:com.example.kotlinprojection.test
 * @date:21-6-29
 * @author:liujianming
 */
class User(var name:String)

fun User.Print(){
    print("用户名 $name")
}

fun main(args:Array<String>) {
    var user = User("Runoob")
    user.Print()
}