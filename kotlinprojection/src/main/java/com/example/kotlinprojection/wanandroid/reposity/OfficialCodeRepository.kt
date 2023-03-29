package com.yicooll.wanandroidkotlin.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlinprojection.wanandroid.network.RetrofitUtil
import com.yicooll.wanandroidkotlin.api_service.OfficialCodeService
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class OfficialCodeRepository {


    private var officialCodeCategoryLiveData = MutableLiveData<ModelOfficialCodeCategory>()
    private var officialCodeListLiveData = MutableLiveData<ModelOfficialCodeList>()

    fun getOfficialCodeCategoryLiveData():MutableLiveData<ModelOfficialCodeCategory>{
        return officialCodeCategoryLiveData
    }
    fun getOfficialCodeListLiveData():MutableLiveData<ModelOfficialCodeList>{
        return officialCodeListLiveData
    }

    fun getOfficialCodeCategory() {
        val client = RetrofitUtil.getRetrofit()
        val service=client!!.create(OfficialCodeService::class.java)
        service.getOfficialCodeCategory()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelOfficialCodeCategory>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelOfficialCodeCategory?) {
                        officialCodeCategoryLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        officialCodeCategoryLiveData.value=null
                    }
                })

    }

    fun getOfficialCodeList(id:Int,pageNum:Int){
        val client = RetrofitUtil.getRetrofit()
        val service=client!!.create(OfficialCodeService::class.java)
        val url="wxarticle/list/$id/$pageNum/json"
        service.getOfficialCodeList(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelOfficialCodeList>{
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelOfficialCodeList?) {
                        officialCodeListLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        officialCodeListLiveData.value=null
                    }
                })
    }

}