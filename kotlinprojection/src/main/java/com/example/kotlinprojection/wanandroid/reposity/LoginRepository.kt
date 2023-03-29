package com.example.kotlinprojection.wanandroid.reposity

import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.UserService
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * LoginRepository
 * @author liujianming
 * @date 2021-12-08
 */
class LoginRepository(username: String, password: String) {

    private val liveLoginData = MutableLiveData<ModelLogin>()

    init {
        doLogin(username, password)
    }

    fun getLoginData(): MutableLiveData<ModelLogin> {
        return liveLoginData
    }

    fun doLogin(username: String, password: String) {
        val client = RetrofitUtil.getRetrofit()
        val service = client!!.create(UserService::class.java)
        service.doLogin(username, password)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelLogin>{
                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelLogin?) {
                        liveLoginData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        liveLoginData.value = null
                    }

                    override fun onComplete() {

                    }

                })
    }
}