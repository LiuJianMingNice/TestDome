package com.example.kotlinprojection.wanandroid.ui.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.Constant
import com.example.kotlinprojection.wanandroid.ui.activity.MainWebActivity
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.example.kotlinprojection.wanandroid.viewmodel.OfficialCodeViewModel
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList
import com.yicooll.wanandroidkotlin.ui.adapter.OfficialCodeAdapter
import kotlinx.android.synthetic.main.fragment_official_code_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [OfficialCodeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OfficialCodeListFragment : BaseFragment() {

    private var vm: OfficialCodeViewModel? = null
    private var pageNum = 1
    private var adapter: OfficialCodeAdapter? = null
    private var data = ArrayList<ModelOfficialCodeList.Data.DataX>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_official_code_list, container, false)
    }

    override fun initView() {
        adapter = OfficialCodeAdapter(R.layout.adapter_offical_code, data)
        rv_offical_code.adapter = adapter
        rv_offical_code.layoutManager = LinearLayoutManager(activity)
        srv_official_code.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private val mHandler = Handler(Looper.getMainLooper()) {
        pageNum = 1
        if (arguments != null) {
            vm?.getOfficialCodeList(arguments!!.getInt("typeId"), pageNum)
        }
        srv_official_code.isRefreshing = false
        return@Handler true
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun initEvent() {

        srv_official_code.setOnRefreshListener {
            mHandler.sendEmptyMessageDelayed(Constant.FRESH_CODE, Constant.LOADING_DELAYED)
        }

        vm = ViewModelProviders.of(this).get(OfficialCodeViewModel::class.java)
        if (arguments != null) {
            vm?.getOfficialCodeList(arguments!!.getInt("typeId"), pageNum)
        }
        vm?.getOfficialCodeListLiveData()?.observe(this, Observer {
            if (pageNum == 1) {
                data.clear()
            }

            it?.let { it1 ->
                data.addAll(it1.data.datas)
                adapter?.notifyDataSetChanged()
                if (it1.data.datas.size < Constant.ONE_PAGE_COUNT) {
                    adapter?.loadMoreEnd()
                } else {
                    adapter?.loadMoreComplete()
                }
            }
        })

        adapter?.setOnLoadMoreListener({
            vm?.getOfficialCodeList(arguments!!.getInt("typeId"), ++pageNum)
        }, rv_offical_code)
        adapter?.setOnItemClickListener { adapter, view, position ->
            val bundle = Bundle()
            bundle.putString("url", data[position].link)
            bundle.putString("title", data[position].title)
            ToActivityHelper.getInstance()?.toActivity(activity as Activity, MainWebActivity::class.java, bundle)
        }
    }

    companion object {
        fun newInstance(typeId: Int): OfficialCodeListFragment {
            val args = Bundle()
            args.putInt("typeId", typeId)
            val fragment = OfficialCodeListFragment()
            fragment.arguments = args
            return fragment
        }
    }

}