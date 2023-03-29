package com.example.kotlinprojection.wanandroid.ui.fragment.goodchild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.kotlinprojection.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main_web.*
import kotlinx.android.synthetic.main.activity_service_test.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [GoodsInfoWebFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoodsInfoWebFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info_web, container, false)
    }

    override fun initView() {
        wvSetting()
        webview.loadUrl("http://m.okhqb.com/item/description/1000334264.html?fromApp=true")
    }

    override fun initEvent() {
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
    }

    fun wvSetting() {
        val webSetting = webview.settings
        webSetting.javaScriptEnabled = true
        //允许js弹框
        webSetting.javaScriptCanOpenWindowsAutomatically = true

        //解决高版本webview不能点击
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                val data = "Page NO FOUND"
                view?.loadUrl("javascript:document.body.innerHTML=\"$data\"")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (webview != null) {
            val parent = webview.parent
            if (parent != null) {
                (parent as ViewGroup).removeView(webview)
            }
            webview.stopLoading()
            webview.settings.javaScriptEnabled = false
            webview.clearHistory()
            webview.removeAllViews()
            webview.destroy()
        }
    }

}