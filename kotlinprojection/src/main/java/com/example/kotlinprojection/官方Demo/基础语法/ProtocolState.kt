package com.example.kotlinprojection.官方Demo.基础语法

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ProtocolState
 * @author liujianming
 * @date 2021-11-22
 */
enum class ProtocolState {

    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}