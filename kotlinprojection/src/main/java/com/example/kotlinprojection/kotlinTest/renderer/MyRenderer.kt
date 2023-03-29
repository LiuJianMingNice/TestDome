package com.example.kotlinprojection.kotlinTest.renderer

import android.opengl.GLSurfaceView
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.IntBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Copyright (c) 2021 Raysharp.cn. All rights reserved.
 *
 * MyRenderer
 * @author liujianming
 * @date 2021-12-01
 */
class MyRenderer : GLSurfaceView.Renderer {

    private var triangleData = floatArrayOf(
            0.1f, 0.6f, 0.0f,
            -0.3f, 0.0f, 0.0f,
            0.3f, 0.1f, 0.0f
    )

    private var triangleColor = intArrayOf(
            65535, 0, 0, 0,
            0, 65535, 0, 0,
            0, 0, 65535, 0
    )

    private var rectData = floatArrayOf(
            0.4f, 0.4f, 0.0f,
            0.4f, -0.4f, 0.0f,
            -0.4f, 0.4f, 0.0f,
            -0.4f, -0.4f, 0.0f
    )

    private var rectColor = intArrayOf(
            0, 65535, 0, 0,
            0, 0, 65535, 0,
            65535, 0, 0, 0,
            65535, 65535, 0, 0
    )

    private var rectData2 = floatArrayOf(
            -0.4f, 0.4f, 0.0f,
            0.4f, 0.4f, 0.0f,
            0.4f, -0.4f, 0.0f,
            -0.4f, -0.4f, 0.0f
    )

    private var pentacle = floatArrayOf(
            0.4f, 0.4f, 0.0f, -0.2f, 0.3f,
            0.0f, 0.5f, 0.0f, 0f, -0.4f,
            0.0f, 0f, -0.1f, -0.3f, 0f
    )

    private var triangleDataBuffer: FloatBuffer
    private var triangleColorBuffer: IntBuffer
    private var rectDataBuffer: FloatBuffer
    private var rectColorBuffer: IntBuffer
    private var rectDataBuffer2: FloatBuffer
    private var pentacleBuffer: FloatBuffer

    init {
        triangleDataBuffer = floatBufferUtil(triangleData)
        rectDataBuffer = floatBufferUtil(rectData)
        rectDataBuffer2 = floatBufferUtil(rectData2)
        pentacleBuffer = floatBufferUtil(pentacle)
        triangleColorBuffer = intBufferUtil(triangleColor)
        rectColorBuffer = intBufferUtil(rectColor)
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        //关闭抗抖动
        gl?.glDisable(GL10.GL_DITHER)
        //设置系统对透视进行修正
        gl?.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST)
        gl?.glClearColor(0f, 0f, 0f, 0f)
        //设置阴影平滑模式
        gl?.glShadeModel(GL10.GL_SMOOTH)
        //启用深度测试
        gl?.glEnable(GL10.GL_DEPTH_TEST)
        //启用深度测试的类型
        gl?.glDepthFunc(GL10.GL_LEQUAL)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        //设置3D视窗的大小及位置
        gl?.glViewport(0, 0, width, height)
        //将当前矩阵模式设为投影矩阵
        gl?.glMatrixMode(GL10.GL_PROJECTION)
        //初始化单位矩阵
        gl?.glLoadIdentity()
        //计算透视视窗的宽度、高度比
        val ratio = width.toFloat() / height
        //调用此方法设置透视视窗的空间大小
        gl?.glFrustumf(-ratio, ratio, -1f, 1f, 1f, 10f)
    }

    override fun onDrawFrame(gl: GL10?) {
        //清除屏幕缓存和深度缓存
        gl?.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        //启用顶点坐标数据
        gl?.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        //启用顶点颜色数据
        gl?.glEnableClientState(GL10.GL_COLOR_ARRAY)
        //设置当前矩阵堆栈为模型堆栈
        gl?.glMatrixMode(GL10.GL_MODELVIEW)
        //绘制第一个图形
        //重置当前的模型视图矩阵
        gl?.glLoadIdentity()
        gl?.glTranslatef(-0.32f, 0.35f, -1.2f)
        //设置顶点的位置数据
        gl?.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleDataBuffer)
        //设置顶点的颜色数据
        gl?.glColorPointer(4, GL10.GL_FIXED, 0, triangleColorBuffer)
        //根据顶点数据绘制平面图形
        gl?.glDrawArrays(GL10.GL_TRIANGLES, 0, 3)
        //绘制第二个图形
        //重置当前的模型视图矩阵
        gl?.glLoadIdentity()
        gl?.glTranslatef(0.6f, 0.8f, -1.5f)
        //设置顶点的位置数据
        gl?.glVertexPointer(3, GL10.GL_FLOAT, 0, rectDataBuffer)
        //设置顶点的颜色数据
        gl?.glColorPointer(4, GL10.GL_FIXED, 0, rectColorBuffer)
        //根据顶点数据绘制平面图形
        gl?.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)
        //绘制第三个图形
        //重置当前的模型视图矩阵
        gl?.glLoadIdentity()
        gl?.glTranslatef(-0.4f, -0.5f, -1.5f)
        //设置顶点的位置数据
        gl?.glVertexPointer(3, GL10.GL_FLOAT, 0, rectDataBuffer2)
        //根据顶点数据绘制平面图形
        gl?.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4)

        //绘制第四个图形
        //重置当前的模型视图矩阵
        gl?.glLoadIdentity()
        gl?.glTranslatef(0.4f, -0.5f, -1.5f)
        //设置使用纯色填充
        gl?.glColor4f(1.0f, 0.2f, 0.2f, 0.0f)
        gl?.glDisableClientState(GL10.GL_COLOR_ARRAY)
        //设置顶点的位置数据
        gl?.glVertexPointer(3, GL10.GL_FLOAT, 0, pentacleBuffer)
        //根据顶点数据绘制平面图形
        gl?.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 5)
        //绘制结束
        gl?.glFinish()
        gl?.glDisableClientState(GL10.GL_VERTEX_ARRAY)

    }

    //定义一个工具方法，将int[]数组转换为OpenGL ES所需的IntBuffer
    private fun intBufferUtil(arr: IntArray): IntBuffer {
        val mBuffer: IntBuffer
        //初始化ByteBuffer，长度为arr数组的长度×4，因为一个int占四个字节
        val qbb = ByteBuffer.allocateDirect(arr.size * 4)
        //数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder())
        mBuffer = qbb.asIntBuffer()
        mBuffer.put(arr)
        mBuffer.position(0)
        return mBuffer
    }

    //定义一个工具方法，将float[]数组转换为OpenGL ES所需的FloatBuffer
    private fun floatBufferUtil(arr: FloatArray): FloatBuffer {
        val mBuffer: FloatBuffer
        //初始化ByteBuffer，长度为arr数组的长度×4，因为一个int占四个字节
        val qbb = ByteBuffer.allocateDirect(arr.size * 4)
        //数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder())
        mBuffer = qbb.asFloatBuffer()
        mBuffer.put(arr)
        mBuffer.position(0)
        return mBuffer
    }
}