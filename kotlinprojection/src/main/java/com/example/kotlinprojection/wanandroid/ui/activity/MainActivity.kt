package com.example.kotlinprojection.wanandroid.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import com.example.kotlinprojection.wanandroid.ui.fragment.IndexFragment
import com.example.kotlinprojection.wanandroid.ui.fragment.MineFragment
import com.example.kotlinprojection.wanandroid.ui.fragment.WeigetFragment
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.include_base_toolbar.*

class MainActivity : BaseActivity() {



    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_noback_toolbar, llMenu)
        tv_menu_center.text = "首页"
    }

    override fun initEvent() {
        changeFragment(IndexFragment::class.simpleName)
        rg_main.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.rb_main -> {
                    changeFragment(IndexFragment::class.simpleName)
                    tv_menu_center.text = "首页"
                }
                R.id.rb_center -> {
                    changeFragment(WeigetFragment::class.simpleName)
                    tv_menu_center.text = "控件"
                }
                R.id.rb_user -> {
                    tv_menu_center.text = "我的"
                    changeFragment(MineFragment::class.simpleName)
                }
            }
        }
    }

    private val mFragmentList = ArrayList<Fragment>()
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_main2
    }

    fun changeFragment(tag: String?) {
        hideFragment()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            transaction.show(fragment)
        } else {
            when (tag) {
                IndexFragment::class.simpleName -> {
                    fragment = IndexFragment()
                }
                WeigetFragment::class.simpleName -> {
                    fragment = WeigetFragment()
                }
                MineFragment::class.simpleName -> {
                    fragment = MineFragment()
                }
            }

            if (fragment != null) {
                mFragmentList.add(fragment)
                transaction.add(R.id.fl_layout, fragment, tag)
            }
        }
        transaction.commitAllowingStateLoss()
    }

    fun hideFragment() {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        for (f in mFragmentList) {
            transaction.hide(f)
        }
        transaction.commit()
    }

}