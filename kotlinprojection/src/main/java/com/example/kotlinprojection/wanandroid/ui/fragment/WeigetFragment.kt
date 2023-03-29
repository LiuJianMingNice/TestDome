package com.example.kotlinprojection.wanandroid.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.ui.activity.CustomerDialogActivity
import com.example.kotlinprojection.wanandroid.ui.activity.ShopDetailActivity
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.Template
import com.yicooll.wanandroidkotlin.ui.adapter.WeigetAdapter
import kotlinx.android.synthetic.main.fragment_weiget.*

/**
 * A simple [Fragment] subclass.
 * Use the [WeigetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeigetFragment : BaseFragment() {

    private val templateList = ArrayList<Template>()
    private var adapter: WeigetAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weiget, container, false)
    }

    override fun initView() {
        adapter = WeigetAdapter(R.layout.adapter_weiget_list, getWeigetData())
        rv_weiget.adapter = adapter
        rv_weiget.layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun initEvent() {
        adapter?.setOnItemClickListener { adapter, view, position ->
            when (position) {
                0 -> ToActivityHelper.getInstance()?.toActivity(activity!!, ShopDetailActivity::class.java)
                1-> ToActivityHelper.getInstance()?.toActivity(activity!!, CustomerDialogActivity::class.java)
            }
        }
    }

    fun getWeigetData(): ArrayList<Template> {
        templateList.clear()
        templateList.add(Template(R.mipmap.main_icon_1, "商城", "电商商品模板，和jd相似"))
        templateList.add(Template(R.mipmap.main_icon_2, "dialog", "炫酷好看的dialog"))
        templateList.add(Template(R.mipmap.main_icon_3, "流式布局", "从左上角位置开始，自动换行"))
        templateList.add(Template(R.mipmap.main_icon_4, "聊天", "多功能列表适配器"))
        templateList.add(Template(R.mipmap.main_icon_5, "图片查看器", "图片查看"))
        return templateList
    }

}