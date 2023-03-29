package com.example.kotlinprojection.kotlinTest.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "接收到的Intent的Action为： " + intent.action + "\n消息内容是： " + intent.getStringExtra("msg"), Toast.LENGTH_LONG).show()
    }
}