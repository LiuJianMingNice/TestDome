package com.example.kotlinprojection.kotlinTest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinTest.customview.DrawView

class ImageTestActivity : AppCompatActivity() {
    //定义一个访问图片的数组
    private var images = intArrayOf(R.mipmap.helpai1, R.mipmap.helpai2, R.mipmap.helpdevice1, R.mipmap.helpfilelist1, R.mipmap.helpfilelist2)
    private var currentImg = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_test)
//        val main = findViewById<LinearLayout>(R.id.root)
//        //程序创建ImageView组件51.6  21.5
//        val image = ImageView(this)
//        //将ImageView组件添加到LinearLayout布局容器中
//        val draw = DrawView(this)
//        draw.minimumWidth = 300
//        draw.minimumHeight = 500
//        main.addView(draw)
////        main.addView(image)
//        image.setImageResource(images[0])
//        image.setOnClickListener {
//            image.setImageResource(images[++currentImg % images.size])
//        }
    }
}