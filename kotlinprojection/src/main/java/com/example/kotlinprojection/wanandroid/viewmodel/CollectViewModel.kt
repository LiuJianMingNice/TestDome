package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.reposity.CollectRepository
import com.yicooll.wanandroidkotlin.entity.ModelCollect

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * CollectViewModel
 * @author liujianming
 * @date 2021-12-09
 */
class CollectViewModel(application: Application) : AndroidViewModel(application) {

    private var collectLiveData: MutableLiveData<ModelCollect>? = null
    private var repository: CollectRepository? = null

    fun getCollectLiveData(): MutableLiveData<ModelCollect>? {
        return collectLiveData
    }

    fun getCollectList(pageNum: Int) {
        repository = CollectRepository()
        repository?.getCollectList(pageNum)
        collectLiveData = repository?.getCollectLiveData()
    }
}