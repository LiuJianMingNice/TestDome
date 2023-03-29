package com.example.kotlinprojection.wanandroid.ui.weiget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.example.kotlinprojection.R

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * ObserverButton
 * @author liujianming
 * @date 2021-12-06
 */
@SuppressLint("AppCompatCustomView")
class ObserverButton(context: Context, attributeSet: AttributeSet) : TextView(context, attributeSet) {
    private val ediTextList = ArrayList<EditText>()

    private var canPress: Boolean = false
    private var defaultBg = Color.GRAY
    private var pressBg = Color.BLUE
    private var defaultTextColor = Color.WHITE
    private var pressTextColor = Color.WHITE
    private var defaultBgRes: Int = 0
    private var pressBgRes: Int = 0

    init {
        val a = context.obtainStyledAttributes(attributeSet, R.styleable.ObserverButton)
        defaultBg = a.getColor(R.styleable.ObserverButton_defaultBgColor, defaultBg)
        pressBg = a.getColor(R.styleable.ObserverButton_pressBgColor, pressBg)
        defaultTextColor = a.getColor(R.styleable.ObserverButton_defaultTextColor, defaultTextColor)
        pressTextColor = a.getColor(R.styleable.ObserverButton_pressTextColor, pressTextColor)
        defaultBgRes = a.getResourceId(R.styleable.ObserverButton_defaultBgResource, 0)
        pressBgRes = a.getResourceId(R.styleable.ObserverButton_pressBgResource, 0)
        a.recycle()
        initBtn()
    }

    fun observer(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    checkEditText()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
            ediTextList.add(editText)
        }
    }

    fun checkEditText() {
        canPress = true
        for (et in ediTextList) {
            if (TextUtils.isEmpty(et.text.trim())) {
                canPress = false
                break
            }
        }
        initBtn()
    }

    private fun initBtn() {
        if (canPress) {
            setTextColor(pressTextColor)
            if (pressBgRes != 0) {
                setBackgroundColor(pressBgRes)
            } else {
                setBackgroundColor(pressBg)
            }
            isEnabled = true
        } else {
            setTextColor(defaultTextColor)
            if (pressBgRes != 0) {
                setBackgroundColor(defaultBgRes)
            } else {
                setBackgroundColor(defaultBg)
            }
            isEnabled = false
        }
    }

}