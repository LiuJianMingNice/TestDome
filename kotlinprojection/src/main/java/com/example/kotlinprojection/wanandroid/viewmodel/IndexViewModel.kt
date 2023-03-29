package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.reposity.IndexRepository
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * IndexViewModel
 * @author liujianming
 * @date 2021-12-14
 */
class IndexViewModel(application: Application): AndroidViewModel(application) {
    private var indexBannerLiveData : MutableLiveData<ModelIndexBanner>? = null
    private var repository: IndexRepository?=null
    private var indexArticalLiveData: MutableLiveData<ModelIndexArtical>?=null

    init {
        repository = IndexRepository()
        indexBannerLiveData = repository?.getBannerLiveData()
        indexArticalLiveData = repository?.getArticalLiveData()
    }

    fun getIndexBanner() {
        repository?.getIndexBanner()
    }

    fun getIndexArtical(pageNum: Int) {
        repository?.getIndexArtical(pageNum)
    }

    fun getBannerLiveData(): MutableLiveData<ModelIndexBanner>?{
        return indexBannerLiveData
    }

    fun getArticalLiveData(): MutableLiveData<ModelIndexArtical>?{
        return indexArticalLiveData
    }
}