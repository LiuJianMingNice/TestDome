package com.example.kotlinprojection.官方Demo.基础语法

import kotlin.coroutines.*

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * Coroutine
 * @author liujianming
 * @date 2021-11-23
 */

//fun main() {
//    test01()
//}

fun test01() {
    val continuation = suspend {
        println("协程执行中...")
        "协程的返回值"
    }.createCoroutine(object : Continuation<String>{
        override fun resumeWith(result: Result<String>) {
            println("协程执行结束： $result")
        }
        override val context: CoroutineContext = EmptyCoroutineContext
    })
    continuation.resume(Unit)
}