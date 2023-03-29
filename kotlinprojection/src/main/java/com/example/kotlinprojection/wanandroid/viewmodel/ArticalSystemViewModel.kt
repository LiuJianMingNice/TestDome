package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.reposity.ArticalSystemRepository
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ArticalSystemViewModel
 * @author liujianming
 * @date 2021-12-08
 */
class ArticalSystemViewModel(application: Application) : AndroidViewModel(application) {
    var repository: ArticalSystemRepository? = null
    var systemCatogoryLiveData: MutableLiveData<ModelSystemCatogry>? = null

    init {
        repository = ArticalSystemRepository()
        systemCatogoryLiveData = repository?.getSystemCatogryLiveData()
    }

    fun getArticalSystemCatogry() {
        repository?.getArticalSystemCatogry()
    }

    fun getSystemCatogryLiveData(): MutableLiveData<ModelSystemCatogry>? {
        return systemCatogoryLiveData
    }
}