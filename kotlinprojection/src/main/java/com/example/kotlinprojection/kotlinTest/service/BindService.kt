package com.example.kotlinprojection.kotlinTest.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BindService : Service() {
    private var count: Int = 0
    private var quit: Boolean = false
    //定义onBinder方法所返回的对象
    private val binder = MyBinder()

    inner class MyBinder : Binder() {
        val count: Int
            get() = this@BindService.count
    }

    override fun onBind(intent: Intent): IBinder {
        Log.d("ljm", "service is Binded")
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("ljm", "Service is Create ")
        object: Thread() {
            override fun run() {
                while (!quit) {
                    Thread.sleep(1000)
                    this@BindService.count++
                }
            }
        }.start()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.d("ljm", "Service is Unbind: ")
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        this.quit = true
        Log.d("ljm", "Service is Destroy: ")
    }
}