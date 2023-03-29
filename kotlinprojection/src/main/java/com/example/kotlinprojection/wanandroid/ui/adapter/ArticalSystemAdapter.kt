package com.example.kotlinprojection.wanandroid.ui.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.kotlinprojection.R
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ArticalSystemAdapter
 * @author liujianming
 * @date 2021-12-06
 */
class ArticalSystemAdapter(layoutResId: Int, data: ArrayList<ModelSystemCatogry.Data>) : BaseQuickAdapter<ModelSystemCatogry.Data, BaseViewHolder> (layoutResId, data) {

    private var onItemClickListener: OnItemClickListener? = null
    private var currentPosition = -1

    fun setCustomerItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun convert(helper: BaseViewHolder?, item: ModelSystemCatogry.Data?) {
        if (helper?.adapterPosition == currentPosition) {
            helper?.getView<TextView>(R.id.tv_category_name)?.setBackgroundResource(R.color.bg_yellow)
        } else {
            helper?.getView<TextView>(R.id.tv_category_name)?.setBackgroundResource(R.color.bg_white)
        }
        helper?.getView<TextView>(R.id.tv_category_name)?.text = item?.name
        helper?.getView<TextView>(R.id.tv_category_name)?.setOnClickListener {
            currentPosition = helper.adapterPosition
            if (onItemClickListener != null) {
                onItemClickListener?.onItemClick(currentPosition)
            }
            notifyDataSetChanged()
        }
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }
}