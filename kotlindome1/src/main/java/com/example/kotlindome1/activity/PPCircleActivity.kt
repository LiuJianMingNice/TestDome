package com.example.kotlindome1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlindome1.R
import com.example.kotlindome1.customview.PPCircle

class PPCircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppcircle)
        Log.d("ljm", "onCreate===>>>")
        val ppCircle = findViewById<PPCircle>(R.id.pp_circle)

        var mDatas = ArrayList<Float>()
        mDatas.add(1f)
        mDatas.add(2f)
        mDatas.add(3f)
        mDatas.add(4f)

        var mColors = ArrayList<Int>()
        mColors.add(0xff83ccd2.toInt())
        mColors.add(0xffc0e1ce.toInt())
        mColors.add(0xfffac55e.toInt())
        mColors.add(0xffef805f.toInt())

        ppCircle.setData(mDatas, mColors)

    }
}