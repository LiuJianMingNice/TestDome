package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.utils.Util
import com.yicooll.wanandroidkotlin.entity.ModelProjectList

class ProjectAdapter(layoutId:Int, data:ArrayList<ModelProjectList.Data.Data>) :BaseQuickAdapter<ModelProjectList.Data.Data,BaseViewHolder>(layoutId,data) {

    override fun convert(helper: BaseViewHolder?, item: ModelProjectList.Data.Data?) {
       Glide.with(mContext).load(item?.envelopePic).into(helper?.getView(R.id.iv_img)!!)
        helper?.getView<TextView>(R.id.tv_des)?.text=item?.desc
        helper?.getView<TextView>(R.id.tv_author)?.text="作者："+item?.author
        helper?.getView<TextView>(R.id.tv_date)?.text= Util.formatData(item?.publishTime)
    }
}