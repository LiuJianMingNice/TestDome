package com.example.kotlinprojection.wanandroid.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.reposity.LoginRepository
import com.yicooll.wanandroidkotlin.entity.ModelLogin

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * LoginViewModel
 * @author liujianming
 * @date 2021-12-09
 */
class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: LoginRepository? = null

    fun doLogin(username: String, password: String) {
        repository = LoginRepository(username, password)
    }

    fun getLoginData(): MutableLiveData<ModelLogin>? {
        return repository?.getLoginData()
    }
}