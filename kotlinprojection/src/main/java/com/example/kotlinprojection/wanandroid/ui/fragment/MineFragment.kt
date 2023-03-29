package com.example.kotlinprojection.wanandroid.ui.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.ui.activity.AboutUsActivity
import com.example.kotlinprojection.wanandroid.ui.activity.CollectActivity
import com.example.kotlinprojection.wanandroid.ui.activity.LoginActivity
import com.example.kotlinprojection.wanandroid.utils.ImageUtils
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.example.kotlinprojection.wanandroid.utils.UserHelper
import com.yicooll.wanandroidkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * A simple [Fragment] subclass.
 * Use the [MineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MineFragment : BaseFragment() {

    override fun onResume() {
        super.onResume()
        displayView()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun initView() {
        ImageUtils.loadImageBlur(iv_bg, url)
        ImageUtils.loadImageCircle(iv_head, url)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun initEvent() {
        tv_login.setOnClickListener {
            ToActivityHelper.getInstance()!!.toActivity(activity!!, LoginActivity::class.java)
        }

        tv_login_out.setOnClickListener {
            UserHelper.getInstance()?.loginOut(activity!!.applicationContext)
            displayView()
        }

        rl_collect.setOnClickListener {
            if (UserHelper.getInstance()?.isLogin(activity as Activity)!!) {
                ToActivityHelper.getInstance()!!.toActivity(activity!!, CollectActivity::class.java)
            } else {
                ToActivityHelper.getInstance()!!.toActivity(activity!!, LoginActivity::class.java)
            }
        }

        rl_about_us.setOnClickListener {
            ToActivityHelper.getInstance()!!.toActivity(activity!!, AboutUsActivity::class.java)
        }
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun displayView() {
        if (UserHelper.getInstance()?.isLogin(activity!!.applicationContext)!!) {
            tv_login_out.visibility = View.VISIBLE
            tv_login.visibility = View.GONE
            iv_head.visibility = View.VISIBLE
        } else {
            tv_login_out.visibility = View.GONE
            tv_login.visibility = View.VISIBLE
            iv_head.visibility = View.GONE
        }
    }

    companion object {
        val url: String = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542110989472&di=e206dfdad3d1197025ddc03bca0b013c&imgtype=0&src=http%3A%2F%2Fwww.pig66.com%2Fuploadfile%2F2017%2F1209%2F20171209121323978.png"
    }
}