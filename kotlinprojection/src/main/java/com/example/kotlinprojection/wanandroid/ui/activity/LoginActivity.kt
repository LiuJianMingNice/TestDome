package com.example.kotlinprojection.wanandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import com.example.kotlinprojection.wanandroid.utils.PreferenceHelper
import com.example.kotlinprojection.wanandroid.viewmodel.LoginViewModel
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import kotlinx.android.synthetic.main.activity_login2.*

class LoginActivity : BaseActivity() {

    private var vm: LoginViewModel? = null

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_login2
    }

    override fun initView() {
        var llMenu: LinearLayout? = getHeadMenu()
        var view: View = layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        var tvTitle: TextView = view.findViewById<TextView>(R.id.tv_menu_center)
        tvTitle.text = "登录"

        tv_login.observer(et_usernmae, et_password)
    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        tv_login.setOnClickListener {
            invalidataInfo()
        }
    }

    fun loginSuccess(ite1: ModelLogin?) {
        showToast("登录成功")
        PreferenceHelper.putBoolean(this, "isLogin", true)
        finish()
    }

    private fun invalidataInfo() {
        if (et_usernmae.text.toString().trim() == "") {
            showToast("请输入用户名")
            return
        }
        if (et_password.text.toString().trim() == "") {
            showToast("请输入密码")
            return
        }
        if (et_password.text.toString().length < 6) {
            showToast("请输入6位以上密码")
            return
        }

        vm?.doLogin(et_usernmae.text.toString().trim(), et_password.text.toString().trim())

        vm!!.getLoginData()?.observe(this, Observer {
            it?.let { it1 ->
                if (it1.errorCode == 0) {
                    loginSuccess(it1)
                } else {
                    showToast(it1.errorMsg)
                }
            }
            if (it == null) {
                showToast("网络异常")
            }
        })
    }

}