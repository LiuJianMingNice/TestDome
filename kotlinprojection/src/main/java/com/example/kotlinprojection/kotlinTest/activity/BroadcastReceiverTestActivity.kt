package com.example.kotlinprojection.kotlinTest.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.kotlinprojection.R

class BroadcastReceiverTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broacast_receiver_test)

        val send = findViewById<Button>(R.id.send_broadcast)
        send.setOnClickListener {
            val intent = Intent()
            intent.action = "com.example.kotlinprojection.kotlinTest.receiver.action.CRAZY_BROADCAST"
//            intent.`package` = "com.example.kotlinprojection.kotlinTest.receiver"
            Log.d("ljm", "packageName: " + packageName)
            intent.setPackage(packageName)
            intent.putExtra("msg", "简单消息")
            sendBroadcast(intent)
        }
    }
}