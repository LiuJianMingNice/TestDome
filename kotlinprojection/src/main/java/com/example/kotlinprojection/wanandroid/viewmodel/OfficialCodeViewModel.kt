package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList
import com.yicooll.wanandroidkotlin.repository.OfficialCodeRepository

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * OfficialCodeViewModel
 * @author liujianming
 * @date 2021-12-14
 */
class OfficialCodeViewModel(application: Application) :AndroidViewModel(application) {

    private var officialCodeCategoryLiveData: MutableLiveData<ModelOfficialCodeCategory>? = null
    private var repository: OfficialCodeRepository? = null
    private var officialCodeListLiveData: MutableLiveData<ModelOfficialCodeList>? = null

    init {
        repository = OfficialCodeRepository()
    }

    fun getOfficialCodeCategoryLiveData(): MutableLiveData<ModelOfficialCodeCategory>? {
        return officialCodeCategoryLiveData
    }

    fun getOfficialCodeListLiveData(): MutableLiveData<ModelOfficialCodeList>? {
        return officialCodeListLiveData
    }


    fun getOfficialCodeCategory() {
        repository?.getOfficialCodeCategory()
        officialCodeCategoryLiveData = repository?.getOfficialCodeCategoryLiveData()
    }

    fun getOfficialCodeList(id:Int,pageNum:Int){
        repository?.getOfficialCodeList(id,pageNum)
        officialCodeListLiveData=repository?.getOfficialCodeListLiveData()
    }
}