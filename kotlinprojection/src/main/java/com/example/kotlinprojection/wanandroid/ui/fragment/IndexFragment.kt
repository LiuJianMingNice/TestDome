package com.example.kotlinprojection.wanandroid.ui.fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bumptech.glide.Glide
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.Constant
import com.example.kotlinprojection.wanandroid.ui.activity.MainWebActivity
import com.example.kotlinprojection.wanandroid.utils.ToActivityHelper
import com.example.kotlinprojection.wanandroid.viewmodel.IndexViewModel
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import com.yicooll.wanandroidkotlin.entity.Template
import com.yicooll.wanandroidkotlin.ui.adapter.IndexArticalAdapter
import com.yicooll.wanandroidkotlin.ui.adapter.IndexBlockAdapter
import kotlinx.android.synthetic.main.fragment_index.*

/**
 * A simple [Fragment] subclass.
 * Use the [IndexFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IndexFragment : BaseFragment() {

    private var vm: IndexViewModel? = null
    private var mImageLoadHoder: BannerHolder? = null
    private var bannerList = ArrayList<ModelIndexBanner.Data>()
    private val templateList = ArrayList<Template>()
    private val articalList = ArrayList<ModelIndexArtical.Data.Data>()
    private val LOADERMORE: Int = 1000
    private var pageNum = 1
    private var articalAdapter: IndexArticalAdapter? = null
    private var banner: ConvenientBanner<*>? =null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun initView() {
        articalAdapter = IndexArticalAdapter(R.layout.wan_item_of_article_list, articalList)
        rv_list.adapter = articalAdapter
        rv_list.layoutManager = LinearLayoutManager(activity)
        articalAdapter?.setOnLoadMoreListener({
            vm?.getIndexArtical(++pageNum)
        }, rv_list)

        val view = layoutInflater.inflate(R.layout.index_header, null, false)
        articalAdapter!!.addHeaderView(view)
        banner = view.findViewById<ConvenientBanner<*>>(R.id.cb_banner)
        banner!!.setPages(CBViewHolderCreator<BannerHolder> {
            if (mImageLoadHoder == null) {
                mImageLoadHoder = BannerHolder()
            }
            return@CBViewHolderCreator mImageLoadHoder
        }, bannerList as List<Nothing>).setPageIndicator(intArrayOf(R.mipmap.ic_indicator_normal, R.mipmap.ic_indicator_selected))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(Constant.BANNER_TURN)

        var rvBlock = view .findViewById<RecyclerView>(R.id.rv_block)
        rvBlock.adapter = IndexBlockAdapter(activity!!, getIndexFuntionBlock())
        rvBlock.layoutManager = GridLayoutManager(activity, 4, GridLayoutManager.VERTICAL, false)

        srv_layout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
    }

    private val handler = Handler(Looper.getMainLooper()) {
        vm?.getIndexBanner()
        pageNum = 1
        vm?.getIndexArtical(pageNum)
        srv_layout.isRefreshing = false
        return@Handler true
    }

    override fun initEvent() {
        srv_layout.setOnRefreshListener {
            handler.sendEmptyMessageDelayed(Constant.FRESH_CODE, Constant.LOADING_DELAYED)
        }
        vm = ViewModelProviders.of(this).get(IndexViewModel::class.java)
        vm?.getBannerLiveData()?.observe(this, Observer {
            bannerList.clear()
            it?.let { it1 ->
                if (it1.errorCode == 0) {
                    bannerList.addAll(it.data)
                    banner?.notifyDataSetChanged()
                } else {
                    showToast(it1.errorMsg)
                }
            }
            if (it == null) {
                showToast(Constant.NETWORK_ERROR)
            }
        })

        vm?.getArticalLiveData()?.observe(this, Observer {
            if (pageNum == 1) {
                articalList.clear()
            }
            it?.let { it1 ->
                articalList.addAll(it1.data.datas)
                articalAdapter?.notifyDataSetChanged()
                if (it.data.datas.size < 20) {
                    articalAdapter?.loadMoreEnd()
                } else {
                    articalAdapter?.loadMoreComplete()
                }
            }
        })

        banner?.setOnItemClickListener {

            val bundle = Bundle()
            bundle.putString("url", bannerList[it].url)
            bundle.putString("title", bannerList[it].title)
            ToActivityHelper.getInstance()?.toActivity(activity as Activity, MainWebActivity::class.java, bundle)
        }

        articalAdapter?.setOnItemClickListener { adapter, view, position ->

            val bundle = Bundle()
            bundle.putString("url", articalList[position].link)
            bundle.putString("title", articalList[position].title)
            ToActivityHelper.getInstance()?.toActivity(activity as Activity, MainWebActivity::class.java, bundle)
        }
    }

    inner class BannerHolder: Holder<ModelIndexBanner.Data> {

        private var imageView: ImageView? = null

        override fun createView(context: Context?): View {
            imageView = ImageView(context)
            imageView!!.scaleType = ImageView.ScaleType.CENTER_CROP
            return imageView as ImageView
        }

        override fun UpdateUI(context: Context?, position: Int, data: ModelIndexBanner.Data?) {
            Glide.with(context!!).load(data!!.imagePath).into(imageView!!)
        }
    }

    fun getIndexFuntionBlock(): List<Template> {
        templateList.clear()
        templateList.add(Template(R.mipmap.wan_icon_1, "体系", ""))
        templateList.add(Template(R.mipmap.wan_icon_2, "项目", ""))
        templateList.add(Template(R.mipmap.wan_icon_3, "公众号", ""))
        templateList.add(Template(R.mipmap.wan_icon_4, "搜索", ""))
        return templateList
    }
}