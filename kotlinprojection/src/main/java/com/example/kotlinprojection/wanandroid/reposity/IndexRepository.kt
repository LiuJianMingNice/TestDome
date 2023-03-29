package com.example.kotlinprojection.wanandroid.reposity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.IndexService
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * IndexRepository
 * @author liujianming
 * @date 2021-12-08
 */
class IndexRepository {

    private var indexBannerLiveData=MutableLiveData<ModelIndexBanner>()
    private var indexArticalLiveData=MutableLiveData<ModelIndexArtical>()


    init {
        getIndexBanner()
        getIndexArtical(1)
    }

    fun getIndexArtical(pageNum:Int) {
        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(IndexService::class.java)
        service.getIndexArtical("article/list/$pageNum/json")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelIndexArtical>{

                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelIndexArtical?) {
                        indexArticalLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        indexArticalLiveData.value=null
                    }
                })

    }

    fun getBannerLiveData():MutableLiveData<ModelIndexBanner>{
        return  indexBannerLiveData
    }

    fun getArticalLiveData():MutableLiveData<ModelIndexArtical>{
        return indexArticalLiveData
    }

    fun getIndexBanner() {
        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(IndexService::class.java)
        service.getIndexBanner()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelIndexBanner>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelIndexBanner?) {
                        indexBannerLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        Log.d("ljm", "error==>> " + e!!.printStackTrace())
                        indexBannerLiveData.value=null
                    }

                })
    }
}