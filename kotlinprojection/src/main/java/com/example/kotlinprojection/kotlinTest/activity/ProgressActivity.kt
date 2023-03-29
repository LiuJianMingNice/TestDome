package com.example.kotlinprojection.kotlinTest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ProgressBar
import com.example.kotlinprojection.R
import java.lang.ref.WeakReference

class ProgressActivity : AppCompatActivity() {

    //该程序模拟填充长度为100的数组
    private val data = IntArray(100)
    private var hasData = 0
    //记录ProgressBar的进度
    internal var status = 0
    private var bar: ProgressBar? = null
//    private var bar2: ProgressBar? = null

    class MyHandler(private val activity: WeakReference<ProgressActivity>): Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.what == 0x111) {
                activity.get()?.bar?.progress = activity.get()?.status!!
//                activity.get()?.bar2?.progress = activity.get()?.status!!
            }
        }
    }

    //创建一个负责更新的进度的Handler
    internal val mHandler = MyHandler(WeakReference(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        bar = findViewById(R.id.bar)

        object : Thread() {
            override fun run() {
                while (status < 100) {
                    //获取耗时操作的完成百分比
                    status = doWork()
                    //发送消息
                    mHandler.sendEmptyMessage(0x111)
                }
            }
        }.start()
    }

    //模拟一个耗时的操作
    fun doWork(): Int {
        //为数组元素赋值
        data[hasData++] = (Math.random() * 100).toInt()
        Thread.sleep(100)
        return hasData
    }
}