package com.example.kotlinprojection.wanandroid.reposity

import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.ArticalSystemService
import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ArticalSystemListRepository
 * @author liujianming
 * @date 2021-12-06
 */
class ArticalSystemListRepository(cid: Int, pageNum: Int) {

    private var articalSystemListLiveData = MutableLiveData<ModelArticalSystemList>()

    init {
        getArticalSystemList(cid, pageNum)
    }

    fun getArticalSystemListLiveData(): MutableLiveData<ModelArticalSystemList> {
        return articalSystemListLiveData
    }

    fun getArticalSystemList(cid: Int, pageNum: Int) {
        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(ArticalSystemService::class.java)
        var url = "article/list/$pageNum/json?cid=$cid"
        service.getArticalSystemList(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelArticalSystemList> {
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelArticalSystemList?) {
                        articalSystemListLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        articalSystemListLiveData.value = null
                    }

                    override fun onComplete() {

                    }

                })
    }
}