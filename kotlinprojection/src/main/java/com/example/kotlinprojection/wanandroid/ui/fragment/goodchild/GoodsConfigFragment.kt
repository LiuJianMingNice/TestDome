package com.example.kotlinprojection.wanandroid.ui.fragment.goodchild

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinprojection.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.GoodsConfigBean
import com.yicooll.wanandroidkotlin.ui.adapter.ShopConfigAdapter
import kotlinx.android.synthetic.main.fragment_goods_config.*

/**
 * A simple [Fragment] subclass.
 * Use the [GoodsConfigFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoodsConfigFragment : BaseFragment() {

    private val configData = ArrayList<GoodsConfigBean>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_config, container, false)
    }

    override fun initView() {

    }

    override fun initEvent() {
        configData.clear()
        configData.add(GoodsConfigBean("品牌", "小米Mix 3"))
        configData.add(GoodsConfigBean("型号", "全面屏 小米Mix 3"))

        val adapter = ShopConfigAdapter(R.layout.adapter_market_of_goods_config_list, configData)
        rv_sku.adapter = adapter
        rv_sku.layoutManager = LinearLayoutManager(activity)
    }

}