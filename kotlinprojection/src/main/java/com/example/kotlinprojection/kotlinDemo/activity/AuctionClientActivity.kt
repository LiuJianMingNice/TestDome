package com.example.kotlinprojection.kotlinDemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinDemo.fragment.AuctionListFragment
import com.example.kotlinprojection.kotlinDemo.fragment.AuctionsListFragment
import com.example.kotlinprojection.kotlinDemo.interfaces.CallBacks

class AuctionClientActivity : AppCompatActivity(), CallBacks {
    //定义一个旗标，用于标示该应用是否支持大屏幕
    private var mTwoPane: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auction_client)

        if (findViewById<View>(R.id.auction_detail_container) != null) {
            mTwoPane = true
//            (supportFragmentManager.findFragmentById(R.id.auction_list) as AuctionListFragment)
//                    .
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onItemSelected(id: Int?, bundle: Bundle?) {

    }


}