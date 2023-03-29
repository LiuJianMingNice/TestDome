package com.example.kotlinprojection.wanandroid.ui.activity

import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.Constant
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.entity.ModelSearch
import com.yicooll.wanandroidkotlin.ui.adapter.SearchAdapter
import com.yicooll.wanandroidkotlin.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search2.*

class SearchActivity : BaseActivity() {

    private var vm: SearchViewModel? = null
    private var pageNum = 1
    private var adapter: SearchAdapter? = null
    private var searchData = ArrayList<ModelSearch.Data.Data>()

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_search2
    }

    override fun initView() {
        adapter = SearchAdapter(R.layout.wan_item_of_article_list, searchData)
        rv_search.layoutManager = LinearLayoutManager(this)
        rv_search.adapter = adapter

        obt_search.observer(edt_search)
    }

    override fun initEvent() {

        vm = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        obt_search.setOnClickListener {
            if (!TextUtils.isEmpty(edt_search.text.toString())) {
                pageNum = 1
                vm?.getSearchData(edt_search.text.toString(), pageNum)
            }
        }

        vm?.getSearchLiveData()?.observe(this, Observer {
            if (pageNum == 1) {
                searchData.clear()
            }
            it?.let { it1 ->
                if (it1.errorCode == 0) {
                    searchData.addAll(it1.data.datas)
                    adapter?.notifyDataSetChanged()
                    if (it1.data.datas.size < Constant.ONE_PAGE_COUNT) {
                        adapter?.loadMoreEnd()
                    } else {
                        adapter?.loadMoreComplete()
                    }
                } else {
                    showToast(it1.errorMsg)
                }
            }
            if (it == null) {
                showToast(Constant.NETWORK_ERROR)
            }
        })

        adapter?.setOnLoadMoreListener({
            if (!TextUtils.isEmpty(edt_search.text.toString())) {
                vm?.getSearchData(edt_search.text.toString(), ++pageNum)
            }
        }, rv_search)

        adapter?.setOnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            bundle.putString("url", searchData[position].link)
            bundle.putString("title", searchData[position].title)
            ToActivityHelper.getInstance()?.toActivity(this, MainWebActivity::class.java, bundle)
        }

        ll_back.setOnClickListener {
            finish()
        }
    }
}