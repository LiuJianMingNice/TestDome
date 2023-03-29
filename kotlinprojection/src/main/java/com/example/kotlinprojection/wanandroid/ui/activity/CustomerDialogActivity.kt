package com.example.kotlinprojection.wanandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_customer_dialog.*

class CustomerDialogActivity : BaseActivity() {

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_customer_dialog
    }

    override fun initView() {
        mHandler.sendEmptyMessageDelayed(1000, 5000)
    }

    override fun initEvent() {

    }

    private val mHandler = Handler(Looper.getMainLooper()) {
        loading_view.visibility = View.GONE
        return@Handler true
    }
}