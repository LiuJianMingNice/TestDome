package com.example.kotlinprojection.wanandroid.ui.activity

import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import kotlinx.android.synthetic.main.include_base_toolbar.*

class AboutUsActivity : BaseActivity() {

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_about_us
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "关于我们"
    }

    override fun initEvent() {

    }
}