package com.example.kotlinprojection.wanandroid.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
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
import com.example.kotlinprojection.wanandroid.ui.activity.ShopDetailActivity
import com.example.kotlinprojection.wanandroid.ui.weiget.SlideLayout
import com.example.kotlinprojection.wanandroid.viewmodel.ShopDetialViewModel
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.ModelGoodsComment
import com.yicooll.wanandroidkotlin.entity.ModelGoodsInfo
import com.yicooll.wanandroidkotlin.ui.adapter.ShopCommentAdapter
import com.yicooll.wanandroidkotlin.ui.adapter.ShopRecommentAdapter
import kotlinx.android.synthetic.main.fragment_goods_comment.*
import kotlinx.android.synthetic.main.fragment_goods_comment.ll_comment
import kotlinx.android.synthetic.main.fragment_goods_comment.recycle_view
import kotlinx.android.synthetic.main.fragment_goods_comment.tv_comment_count
import kotlinx.android.synthetic.main.fragment_goods_comment.tv_praise_rate
import kotlinx.android.synthetic.main.fragment_goods_info_main.*
import kotlinx.android.synthetic.main.market_fragment_goods_comment.*

/**
 * A simple [Fragment] subclass.
 * Use the [GoodsInfoMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoodsInfoMainFragment : BaseFragment() {

    private var vm: ShopDetialViewModel? = null
    private val goodsHeadImg = ArrayList<String>()
    private var mImageLoadHolder: BannerHolder? = null
    private var mRecommentHolder: RecommentHolder? = null
    private val commentList = ArrayList<ModelGoodsComment>()
    private var commentAdapter: ShopCommentAdapter? = null
    private var recommentGropList = ArrayList<List<ModelGoodsInfo>>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info_main, container, false)
    }

    override fun initView() {
        vp_item_goods_img.setPages(CBViewHolderCreator<BannerHolder> {
            if (mImageLoadHolder == null) {
                mImageLoadHolder = BannerHolder()
            }
            return@CBViewHolderCreator mImageLoadHolder
        }, goodsHeadImg as List<Nothing>).setPageIndicator(intArrayOf(R.mipmap.ic_indicator_normal, R.mipmap.ic_indicator_selected))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(Constant.BANNER_TURN)

        commentAdapter = ShopCommentAdapter(R.layout.adapter_market_item_of_goods_comment, commentList)
        recycle_view.adapter = commentAdapter
        recycle_view.layoutManager = LinearLayoutManager(activity)
        recycle_view.isNestedScrollingEnabled = false

        vp_recommend.setPages(CBViewHolderCreator<RecommentHolder> {
            if (mRecommentHolder == null) {
                mRecommentHolder = RecommentHolder()
            }
            return@CBViewHolderCreator mRecommentHolder
        }, recommentGropList as List<Nothing>).setPageIndicator(intArrayOf(R.drawable.shape_item_index_red, R.drawable.shape_item_index_white))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(Constant.BANNER_TURN)
    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(ShopDetialViewModel::class.java)
        vm?.getGoodsInfoLiveData()?.observe(this, Observer {
            goodsHeadImg.clear()
            it?.let { it1 ->
                if (it1.goodsHeadImg != null) {
                    goodsHeadImg.addAll(it1.goodsHeadImg)
                    vp_item_goods_img.notifyDataSetChanged()
                    setGoodsInfo(it1)
                }
            }
        })
        vm?.getRecommendLiveData()?.observe(this, Observer {
            recommentGropList.clear()
            it?.let { it1 ->
                recommentGropList.addAll(it1)
                vp_recommend.notifyDataSetChanged()
            }
        })

        vm?.getCommentLiveData()?.observe(this, Observer {
            commentList.clear()
            it?.let { it1 ->
                commentList.addAll(it1)
                commentAdapter?.notifyDataSetChanged()
            }
        })

        ll_pull_up.setOnClickListener{
            sv_switch.smoothOpen(true)
        }

        ll_comment.setOnClickListener {
            val currentActivity = activity as ShopDetailActivity
            currentActivity.setCurrentPage(2)
        }

        sv_switch.setOnSlideDetailsListener {
            val currentActivity = activity as ShopDetailActivity
            currentActivity?.setViewContent(SlideLayout.Status.OPEN == it)
        }
    }

    fun setGoodsInfo(goodsInfo: ModelGoodsInfo) {

        tv_goods_name.text = goodsInfo.goodsName
        tv_goods_price.text = "￥" + goodsInfo.goodsPrice
        tv_old_price.text = "￥" + goodsInfo.goodsOldPrice
        tv_comment_count.text = "用户点评(" + goodsInfo.commentCount + ")"
        tv_praise_rate.text = "好评率" + goodsInfo.praiseRate

    }

    inner class BannerHolder : Holder<String> {

        private var imageView: ImageView? = null
        override fun createView(context: Context?): View? {
            imageView = ImageView(context)
            imageView!!.scaleType = ImageView.ScaleType.CENTER_CROP
            return imageView
        }

        override fun UpdateUI(context: Context?, position: Int, data: String?) {
            Glide.with(context!!).load(data).into(imageView!!)
        }

    }

    inner class RecommentHolder : Holder<ArrayList<ModelGoodsInfo>> {

        private var recyclerView: RecyclerView? = null

        override fun createView(context: Context?): View? {
            val view = layoutInflater.inflate(R.layout.adapter_market_of_goods_recommend, null)
            recyclerView = view.findViewById(R.id.recycle_view)
            return recyclerView
        }

        override fun UpdateUI(context: Context?, position: Int, data: ArrayList<ModelGoodsInfo>?) {
            recyclerView?.adapter = ShopRecommentAdapter(R.layout.adapter_market_of_goods_recommend_list, data!!)
            recyclerView?.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        }

    }

}