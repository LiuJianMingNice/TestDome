package com.example.kotlinprojection.wanandroid.ui.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.appcompat.app.AlertDialog
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_web.*
import kotlinx.android.synthetic.main.include_base_toolbar.*

class MainWebActivity : BaseActivity() {

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_main_web
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        var url = ""
        if (intent !== null) {
            tv_menu_center.text = intent.getStringExtra("title")
            url = intent.getStringExtra("url")!!
        }
        wvSetting()
        webview.loadUrl(url)
    }

    override fun initEvent() {
        im_back.setOnClickListener {
            if (webview.canGoBack()) {
                webview.goBack()
            } else {
                finish()
            }
        }
    }

    fun wvSetting() {
        val webSetting = webview.settings
        webSetting.javaScriptEnabled = true
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

        webview.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                val b = AlertDialog.Builder(this@MainWebActivity)
                b.setTitle("Alert")
                b.setMessage(message)
                b.setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->  })
                b.setCancelable(false)
                b.create().show()
                return true
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    pgb_webview.visibility = View.GONE
                } else {
                    pgb_webview.visibility = View.VISIBLE
                    pgb_webview.progress = newProgress
                }
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
            //退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            webview.settings.javaScriptEnabled = false
            webview.clearHistory()
            webview.removeAllViews()
            webview.destroy()
        }
    }
}