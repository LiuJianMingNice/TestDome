package com.example.kotlinprojection.wanandroid.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.base.BaseActivity
import com.example.kotlinprojection.wanandroid.ui.fragment.GoodsCommentFragment
import com.example.kotlinprojection.wanandroid.ui.fragment.GoodsInfoDetailMainFragment
import com.example.kotlinprojection.wanandroid.ui.fragment.GoodsInfoMainFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_shop_detail.*

class ShopDetailActivity : BaseActivity() {

    private val fragmentList = ArrayList<Fragment>()
    private val titleArray = arrayOf("商品", "详情", "评价")
    private lateinit var menuTitle: TextView
    private lateinit var tabLayout: TabLayout

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_shop_detail
    }

    override fun initView() {

        val llMenu = getHeadMenu()
        val view = layoutInflater.inflate(R.layout.include_tab_toolbar, llMenu)
        tabLayout = view.findViewById<TabLayout>(R.id.tab_detial_type)
        menuTitle = view.findViewById<TextView>(R.id.tv_menu_center)

        fragmentList.clear()
        val mainFragment = GoodsInfoMainFragment()
        fragmentList.add(mainFragment)
        val detailFragment = GoodsInfoDetailMainFragment()
        fragmentList.add(detailFragment)
        val commentFragment = GoodsCommentFragment()
        fragmentList.add(commentFragment)
        viewpager.adapter = VpAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewpager)
    }

    override fun initEvent() {

    }

    fun setViewContent(scrollToBottom: Boolean) {
        if (scrollToBottom) {
            viewpager.setNoScroll(true)
            tabLayout.visibility = View.GONE
            menuTitle.visibility = View.VISIBLE
            menuTitle.text = "图文详情"
        } else {
            viewpager.setNoScroll(false)
            tabLayout.visibility = View.VISIBLE
            menuTitle.visibility = View.GONE
        }
    }

    fun setCurrentPage(position: Int) {
        viewpager.currentItem = position
    }

    @SuppressLint("WrongConstant")
    inner class VpAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleArray[position]
        }

    }
}