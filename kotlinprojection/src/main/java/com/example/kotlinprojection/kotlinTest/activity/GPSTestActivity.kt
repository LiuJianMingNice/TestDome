package com.example.kotlinprojection.kotlinTest.activity

import android.content.Context
import android.location.Criteria
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.kotlinprojection.R

class GPSTestActivity : AppCompatActivity() {
    private lateinit var providers: ListView
    private lateinit var lm: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gpstest)
        providers = findViewById(R.id.gps_info_list)
        //获取系统的LocationManager对象
        lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        //创建一个LocationProvider的过滤条件
        val cri = Criteria()
        //设置要求LocationProvider必须是免费的
        cri.isCostAllowed = false
        //设置要求LocationProvider能提供高度信息
        cri.isAltitudeRequired = true
        //设置要求LocationProvider能提供方向信息
        cri.isBearingRequired = true
        //获取系统中所有符合条件的LocationProvider的名称
        val providerNames = lm.getProviders(cri, false)
//        //获取系统所有的LocationProvider的名称
//        val providerNames = lm.allProviders
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, providerNames)
        providers.adapter = adapter
    }
}