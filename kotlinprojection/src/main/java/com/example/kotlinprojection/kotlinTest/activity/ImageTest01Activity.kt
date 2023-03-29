package com.example.kotlinprojection.kotlinTest.activity

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.kotlinprojection.R

class ImageTest01Activity : AppCompatActivity() {

    private var images = intArrayOf(R.mipmap.helpfilelist1, R.mipmap.helpfilelist2, R.mipmap.helpdevice1)
    private var currentImg = 2
    private var alpha = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_test01)

        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val next = findViewById<Button>(R.id.next)
        val image1 = findViewById<ImageView>(R.id.image1)
        val image2 = findViewById<ImageView>(R.id.image2)

        next.setOnClickListener {
            image1.setImageResource(images[++currentImg % images.size])
        }

        //定义改变图片透明度的方法
        val listener = View.OnClickListener{ v ->
            if (v == plus) {
                alpha += 20
            }
            if (v == minus) {
                alpha -= 20
            }
            if (alpha >= 255) {
                alpha = 255
            }
            if (alpha <= 0) {
                alpha = 0
            }
            image1.imageAlpha = alpha
        }

        plus.setOnClickListener(listener)
        minus.setOnClickListener(listener)
        image1.setOnTouchListener { v, event ->
            val bitmapDrawable = image1.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            val scale = 1.0 * bitmap.height / image1.getHeight()
            var x = (event.x * scale).toInt()
            var y = (event.y * scale).toInt()
            if (x + 120 > bitmap.width) {
                x = bitmap.width - 120
            }
            if (y + 120 > bitmap.height) {
                y = bitmap.height - 120
            }
            image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120))
            image2.imageAlpha = alpha
            false
        }
    }
}