package com.example.kotlinprojection.kotlinTest.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class FirstService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        println("Service is Created")
        Log.d("ljm", "Service is Created: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("Service is Started")
        Log.d("ljm", "Service is Started: ")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Service is Destroyed")
        Log.d("ljm", "Service is Destroyed: ")
    }
}