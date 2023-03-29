package com.example.kotlinprojection.kotlinTest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.kotlinprojection.R

class SearchViewTestActivity : AppCompatActivity() {

    //自动完成的列表
    private val mStrings = arrayOf("aaaaa", "bbbbb", "ccccc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val lv = findViewById<ListView>(R.id.lv)
        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mStrings)
        //设置ListView启用过滤
        lv.isTextFilterEnabled = true
        val sv = findViewById<SearchView>(R.id.sv)
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(false)
        //设置该SearchView显示搜索按钮
        sv.isSubmitButtonEnabled = true
        //设置该SearchView内默认显示的提示文本
        sv.queryHint = "查找"
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //实际应用中应该在该方法内执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(this@SearchViewTestActivity, "您的选择是： " + query, Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (TextUtils.isEmpty(newText)) {
                    lv.clearTextFilter()
                } else {
                    lv.setFilterText(newText)
                }
                return true
            }

        })
    }
}