package com.example.kotlinprojection.kotlinDemo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinDemo.util.DialogUtil
import com.example.kotlinprojection.kotlinDemo.util.HttpUtil
import java.lang.Exception

class LoginActivity : AppCompatActivity() {
    //定义界面中的两个文本框
    private lateinit var etName: EditText
    private lateinit var etPass: EditText
    //定义界面中的两个按钮
    private lateinit var bnLogin: Button
    private lateinit var bnCancel: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //获取界面中的两个编辑框
        etName = findViewById(R.id.userEditText)
        etPass = findViewById(R.id.pwdEditText)
        //获取界面中的两个按钮
        bnLogin = findViewById(R.id.btn_login)
        bnCancel = findViewById(R.id.btn_cancel)
        //为bnCancel按钮的单击事件绑定事件监听器
//        bnCancel.setOnClickListener(HomeListener(this))
        bnLogin.setOnClickListener {
            if (validate()) {
                if (!loginPro()) {
                    val intent = Intent(this,AuctionClientActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    DialogUtil.showDialog(this, "用户名或者密码错误，请重新输入!", false)
                }
            }
        }
    }

    private fun loginPro(): Boolean {
        //获取用户输入的用户名、密码
        val username = etName.text.toString()
        val pwd = etPass.text.toString()
        try {
            val result = query(username, pwd)
            if (result != null && result.toInt() > 0) {
                return true
            }
        } catch (e: Exception) {
            DialogUtil.showDialog(this, "服务器响应异常，请稍后再试!", false)
            e.printStackTrace()
        }
        return false
    }

    private fun validate(): Boolean {
        val username = etName.text.toString().trim(){
            it <= ' '
        }
        if (username == "") {
            DialogUtil.showDialog(this, "用户账号是必填项", false)
            return false
        }
        val pwd = etPass.text.toString().trim() {
            it <= ' '
        }
        if (pwd == "") {
            DialogUtil.showDialog(this, "用户密码是必填项", false)
            return false
        }
        return true
    }

    private fun query(username: String, password: String): String? {
        //使用Map封装请求参数
        val map = HashMap<String, String>()
        map["username"] = username
        map["userpass"] = password
        //定义发送请求的URL
        val url = HttpUtil.BASE_URL + "users/login"
        //发送请求
        return HttpUtil.postRequest(url, map)
    }
}