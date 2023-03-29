package com.example.kotlinprojection.kotlinDemo.util

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.View
import com.example.kotlinprojection.kotlinDemo.activity.AuctionClientActivity

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * DialogUtil
 * @author liujianming
 * @date 2021-12-03
 */
object DialogUtil {
    //定义一个显示消息的对话框
    fun showDialog(ctx: Context, msg: String?, goHome: Boolean) {
        //创建一个AlertDialog。Builder对象
        val builder = AlertDialog.Builder(ctx)
                .setMessage(msg).setCancelable(false)
        if (goHome) {
            builder.setPositiveButton("确定"){_,_ ->
                val i = Intent(ctx, AuctionClientActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                ctx.startActivity(i)
            }
        } else {
            builder.setPositiveButton("确定", null)
        }
        builder.create().show()
    }

    //定义一个显示指定组件的对话框
    fun showDialog(ctx: Context, view: View) {
        AlertDialog.Builder(ctx)
                .setView(view).setCancelable(false)
                .setPositiveButton("确定", null)
                .create()
                .show()
    }
}