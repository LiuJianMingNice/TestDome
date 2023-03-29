package com.example.kotlinprojection.kotlinTest.activity

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinTest.renderer.MyRenderer

class RendererTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //创建一个GLSurfaceView，用于显示OpenGL绘制的图形
        val glView = GLSurfaceView(this)
        val myRender = MyRenderer()
        //为GLSurfaceView设置绘制器
        glView.setRenderer(myRender)
        setContentView(glView)
    }
}