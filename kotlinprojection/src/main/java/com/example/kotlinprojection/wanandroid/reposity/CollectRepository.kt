package com.example.kotlinprojection.wanandroid.reposity

import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.CollectService
import com.yicooll.wanandroidkotlin.entity.ModelCollect
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * CollectRepository
 * @author liujianming
 * @date 2021-12-07
 */
class CollectRepository {

    private val collectLiveData = MutableLiveData<ModelCollect>()

    fun getCollectLiveData(): MutableLiveData<ModelCollect> {
        return collectLiveData
    }

    fun getCollectList(pageNum: Int) {
        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(CollectService::class.java)
        val url = "lg/collect/list/$pageNum/json"
        service.getCollectList(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelCollect> {
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelCollect?) {
                        collectLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        collectLiveData.value = null
                    }

                    override fun onComplete() {

                    }

                })
    }

}