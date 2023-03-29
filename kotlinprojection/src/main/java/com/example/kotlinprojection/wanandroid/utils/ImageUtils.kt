package com.example.kotlinprojection.wanandroid.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinprojection.R
import com.example.kotlinprojection.wanandroid.manager.BlurTransformation

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ImageUtils
 * @author liujianming
 * @date 2021-12-03
 */
class ImageUtils {

    companion object {
        fun loadImageBlur(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                    .load(url)
                    .apply(RequestOptions.bitmapTransform(
                            BlurTransformation(imageView.context)))
                    .into(imageView)
        }

        fun loadImageCircle(imageView: ImageView, url: String) {
            if (TextUtils.isEmpty(url)) {
                return
            }

            Glide.with(imageView.context)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.ic_loading_image)
                    .error(ColorDrawable(Color.WHITE)).fallback(ColorDrawable(Color.RED))).into(imageView)
        }
    }
}