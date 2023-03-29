package com.example.kotlinprojection.kotlinTest.activity

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * CodeViewActivity
 * @author liujianming
 * @date 2021-11-25
 */
class CodeViewActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //创建一个线性布局管理器
        val layout = LinearLayout(this)
        super.setContentView(layout)
        //设置该Activity显示layout
        layout.orientation = LinearLayout.VERTICAL
        //创建一个TextView
        val show = TextView(this)
        //创建一个按钮
        val bn = Button(this)
        bn.setText("ok")
        bn.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                    ViewGroup.LayoutParams.WRAP_CONTENT)
        //向layout容器中添加TextView
        layout.addView(show)
        //向layout容器添加按钮
        layout.addView(bn)
        //为按钮绑定一个事件监听器
        bn.setOnClickListener {
            show.text = "Hello, Android, " + java.util.Date()
        }
    }
}