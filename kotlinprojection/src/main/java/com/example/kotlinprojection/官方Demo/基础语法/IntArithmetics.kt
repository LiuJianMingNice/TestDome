package com.example.kotlinprojection.官方Demo.基础语法

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * IntArithmetics
 * @author liujianming
 * @date 2021-11-22
 */
@RequiresApi(Build.VERSION_CODES.N)
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },

    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val a = 13
    val b = 31
    for (f in IntArithmetics.values()) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }
}
