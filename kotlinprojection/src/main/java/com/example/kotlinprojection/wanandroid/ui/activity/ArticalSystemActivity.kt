package com.example.kotlinprojection.wanandroid.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.Constant
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import com.example.kotlinprojection.wanandroid.ui.adapter.ArticalSystemAdapter
import com.example.kotlinprojection.wanandroid.ui.adapter.ArticalSystemChildrenAdapter
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.example.kotlinprojection.wanandroid.viewmodel.ArticalSystemViewModel
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import kotlinx.android.synthetic.main.activity_artical_system.*
import kotlinx.android.synthetic.main.include_base_toolbar.*

class ArticalSystemActivity : BaseActivity() {

    private var vm: ArticalSystemViewModel? = null
    private var categoryData = ArrayList<ModelSystemCatogry.Data>()
    private var categoryChildData = ArrayList<ModelSystemCatogry.Data.Children>()
    private var articalSystemAdapter: ArticalSystemAdapter? = null
    private var articalSystemChildrenAdapter: ArticalSystemChildrenAdapter? = null

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_artical_system
    }

    @SuppressLint("ResourceAsColor")
    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "体系"

        articalSystemAdapter = ArticalSystemAdapter(R.layout.adapter_category_item, categoryData)
        rv_p_category.layoutManager = LinearLayoutManager(this)
        rv_p_category.adapter = articalSystemAdapter

        articalSystemChildrenAdapter = ArticalSystemChildrenAdapter(R.layout.adapter_category_item, categoryChildData)
        rv_c_category.layoutManager = LinearLayoutManager(this)
        rv_c_category.adapter = articalSystemChildrenAdapter

        srv_system.setColorSchemeColors(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
    }

    private val mHandler = Handler {
        vm?.getArticalSystemCatogry()
        srv_system.isRefreshing = false
        return@Handler true
    }

    override fun initEvent() {
        srv_system.setOnRefreshListener {
            mHandler.sendEmptyMessageDelayed(Constant.FRESH_CODE, Constant.LOADING_DELAYED)
        }

        vm = ViewModelProviders.of(this).get(ArticalSystemViewModel::class.java)
        vm?.systemCatogoryLiveData?.observe(this, Observer{
            categoryData.clear()
            it?.let {
                it1 ->
                if (it1.errorCode == 0) {
                    categoryData.addAll(it1.data)
                } else {
                    showToast(it1.errorMsg)
                }
            }
            if (it == null) {
                showToast(Constant.NETWORK_ERROR)
            }
            articalSystemAdapter?.notifyDataSetChanged()
        })
        articalSystemAdapter?.setCustomerItemClickListener(object : ArticalSystemAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                categoryChildData.clear()
                categoryChildData.addAll(categoryData[position].children)
                articalSystemChildrenAdapter?.update()
            }
        })

        articalSystemChildrenAdapter?.setCustomerItemClickListener(object : ArticalSystemChildrenAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("title", categoryChildData[position].name)
                bundle.putInt("cid", categoryChildData[position].id)
                ToActivityHelper.getInstance()?.toActivity(this@ArticalSystemActivity, ArticalSystemListActivity::class.java, bundle)
            }
        })
    }
}