package com.example.kotlinprojection.wanandroid.reposity

import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.ArticalSystemService
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ArticalSystemRepository
 * @author liujianming
 * @date 2021-12-07
 */
class ArticalSystemRepository {

    val catogryLiveData = MutableLiveData<ModelSystemCatogry>()

    init {
        getArticalSystemCatogry()
    }

    fun getSystemCatogryLiveData(): MutableLiveData<ModelSystemCatogry> {
        return catogryLiveData
    }

    fun getArticalSystemCatogry() {

        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(ArticalSystemService::class.java)
        service.getActicalSystemCatogry()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelSystemCatogry> {
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelSystemCatogry?) {
                        catogryLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        catogryLiveData.value = null
                    }

                    override fun onComplete() {

                    }

                })
    }
}