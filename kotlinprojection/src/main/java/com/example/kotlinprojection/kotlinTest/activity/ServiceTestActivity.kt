package com.example.kotlinprojection.kotlinTest.activity

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinTest.service.BindService
import com.example.kotlinprojection.kotlinTest.service.FirstService

class ServiceTestActivity : AppCompatActivity() {
    //保持所启动过得Service的IBinder对象
    private lateinit var binder: BindService.MyBinder
    //定义一个ServiceConnection对象
    private val conn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("ljm", "Service Connected: ")
            binder = service as BindService.MyBinder
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("ljm", "Service Disconnected: ")
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_test)

        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)

        val intent = Intent(this, FirstService::class.java)
        start.setOnClickListener {
//            startService(intent)
            bindService(intent, conn, Service.BIND_AUTO_CREATE)
        }
        stop.setOnClickListener {
//            stopService(intent)
            unbindService(conn)
        }
    }
}