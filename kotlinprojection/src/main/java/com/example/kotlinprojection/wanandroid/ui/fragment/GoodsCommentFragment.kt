package com.example.kotlinprojection.wanandroid.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.viewmodel.ShopDetialViewModel
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.ModelGoodsComment
import com.yicooll.wanandroidkotlin.ui.adapter.ShopCommentAdapter
import kotlinx.android.synthetic.main.fragment_goods_comment.*

/**
 * A simple [Fragment] subclass.
 * Use the [GoodsCommentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoodsCommentFragment : BaseFragment() {

    private var vm: ShopDetialViewModel? = null
    private val commentList = ArrayList<ModelGoodsComment>()
    private var commentAdapter: ShopCommentAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_comment, container, false)
    }

    override fun initView() {
        recycle_view.adapter = ShopCommentAdapter(R.layout.adapter_market_item_of_goods_comment, commentList)
        recycle_view.layoutManager = LinearLayoutManager(activity)

        tv_comment_count.text = "用户点评(999)"
        tv_praise_rate.text = "好评率97.8%"
    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(ShopDetialViewModel::class.java)
        vm?.getCommentLiveData()?.observe(this, Observer{
            commentList.clear()
            it?.let { it1 ->
                commentList.addAll(it1)
                commentAdapter?.notifyDataSetChanged()
            }
        })
    }

}