package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.reposity.ArticalSystemListRepository
import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ArticalSystemListViewModel
 * @author liujianming
 * @date 2021-12-08
 */
class ArticalSystemListViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: ArticalSystemListRepository? = null
    private var articalSystemListLiveData: MutableLiveData<ModelArticalSystemList>? = null

    fun initRequest(cid: Int, pageNum:Int) {
        repository = ArticalSystemListRepository(cid, pageNum)
        articalSystemListLiveData = repository?.getArticalSystemListLiveData()
    }

    fun getArticalSystemListLiveData(): MutableLiveData<ModelArticalSystemList>? {
        return articalSystemListLiveData
    }

    fun getArticalSystemList(cid: Int,pageNum:Int) {
        repository?.getArticalSystemList(cid,pageNum)
    }
}