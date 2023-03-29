package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelGoodsComment
import com.yicooll.wanandroidkotlin.entity.ModelGoodsInfo
import com.yicooll.wanandroidkotlin.repository.ShopDetialRepository

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ShopDetialViewModel
 * @author liujianming
 * @date 2021-12-09
 */
class ShopDetialViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: ShopDetialRepository? = null
    private var goodsInfoLiveData = MutableLiveData<ModelGoodsInfo>()
    private var recommendLiveData = MutableLiveData<List<List<ModelGoodsInfo>>>()
    private var commentLiveData = MutableLiveData<List<ModelGoodsComment>>()

    init {
        repository = ShopDetialRepository()
        repository?.getCommentList()
        repository?.getRecommendList()
        repository?.getGoodsInfo()
        goodsInfoLiveData = repository?.getGoodsInfoLiveData()!!
        recommendLiveData = repository?.getRecommendLiveData()!!
        commentLiveData = repository?.getCommentLiveData()!!
    }

    fun getCommentLiveData(): MutableLiveData<List<ModelGoodsComment>> {
        return commentLiveData
    }

    fun getRecommendLiveData(): MutableLiveData<List<List<ModelGoodsInfo>>> {
        return recommendLiveData
    }

    fun getGoodsInfoLiveData(): MutableLiveData<ModelGoodsInfo> {
        return goodsInfoLiveData
    }
}