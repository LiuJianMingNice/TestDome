package com.example.kotlinprojection.kotlinTest.activity

import android.animation.*
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import com.example.kotlinprojection.R
import com.example.kotlinprojection.kotlinTest.util.ShapeHolder

//定义小球大小的常量
const val BALL_SIZE = 50f
//定义小球从屏幕上方下落到屏幕底端的总时间
const val FULL_TIME = 1000f

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val container = findViewById<LinearLayout>(R.id.ll_root)
        container.addView(MyAnimationView(this))
    }

    inner class MyAnimationView(context: Context) : View(context), ValueAnimator.AnimatorUpdateListener {
        val balls = ArrayList<ShapeHolder>()
        init {
            setBackgroundColor(Color.WHITE)
        }

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            if (event?.action != MotionEvent.ACTION_DOWN &&
                event?.action != MotionEvent.ACTION_MOVE) {
                return false
            }
            //在事件发生点添加一个小球(用一个圆形代表)
            val newBall = addBall(event.x, event.y)
            //计算小球下落动画开始时的y坐标
            val startY = newBall.y
            //计算小球下落动画结束时的y坐标(落到屏幕最下方，就是屏幕高度减去小球高度)
            val endY = height - BALL_SIZE
            //获取屏幕高度
            val h = height.toFloat()
            val eventY = event.y
            //计算动画的持续时间
            val duration = (FULL_TIME * ((h - eventY) / h)).toInt()
            //定义小球落下的动画
            //让newBall对象的y属性从事件发生点变化到屏幕最下方
            val fallAnim = ObjectAnimator.ofFloat(newBall, "y", startY, endY)
            //设置fallAnim动画的持续时间
            fallAnim.duration = duration.toLong()
            //设置fallAnim动画的插值方式：加速插值
            fallAnim.interpolator = AccelerateInterpolator()
            //为fallAnim动画添加监听器
            //当ValueAnimator的属性值发生改变是，将会激发该监听器的事件监听方法
            fallAnim.addUpdateListener(this)
            //定义对newBAll对象的alpha属性执行从1到0的动画
            val fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f)
            //设置动画持续时间
            fadeAnim.duration = 250
            //为fadeAnim动画添加监听器
            fadeAnim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    //动画结束时将该动画关联的ShapeHolder删除
                    balls.remove((animation as ObjectAnimator).target)
                }
            })

            //为fadeAnim动画添加监听器
            //当ValueAnimator的属性值发生改变时，将会激发该监听器的事件监听方法
            fadeAnim.addUpdateListener(this)
            //定义一个AnimatorSet来组合动画
            val animatorSet = AnimatorSet()
            //指定在播放fadeAnim之前，先播放fallAnim动画
            animatorSet.play(fallAnim).before(fadeAnim)
            //开始播放动画
            animatorSet.start()
            return true
        }

        private fun addBall(x: Float, y: Float): ShapeHolder {
            //创建一个圆
            val circle = OvalShape()
            //设置该圆的宽高
            circle.resize(BALL_SIZE, BALL_SIZE)
            //将圆包装成Drawable对象
            val drawable = ShapeDrawable(circle)
            //创建一个ShapeHolder对象
            val shapeHolder = ShapeHolder(drawable)
            //设置ShapeHolder的x、y坐标
            shapeHolder.x = x - BALL_SIZE / 2
            shapeHolder.y = y - BALL_SIZE / 2
            val red = (Math.random() * 255).toInt()
            val green = (Math.random() * 255).toInt()
            val blue = (Math.random() * 255).toInt()

            //将red、green、blue三个随机数组合成ARGB颜色
            val color = -0x1000000 + red shl 16 or (green shl 8) or blue
            //获取drawable上关联的画笔
            val paint = drawable.paint
            //将red、green、blue三个随机数除以4得到商值组合成ARGB颜色
            val darkColor = (-0x1000000 or (red / 4 shl 16) or (green / 4 shl 8) or blue / 4)
            //创建圆形渐变
            val gradient = RadialGradient(37.5f, 12.5f, BALL_SIZE, color, darkColor, Shader.TileMode.CLAMP)
            paint.shader = gradient
            //为shapeHolder设置paint画笔
            shapeHolder.paint = paint
            balls.add(shapeHolder)
            return shapeHolder
        }

        override fun onDraw(canvas: Canvas?) {
            for (shapeHolder in balls) {
                //保存canvas的当前坐标系统
                canvas?.save()
                //坐标变换：将画布坐标系统平移到shapeHolder的X、Y坐标处
                canvas?.translate(shapeHolder.x, shapeHolder.y)
                //将ShapeHolder持有的圆形绘制在Canvas上
                shapeHolder.shape?.draw(canvas!!)
                //恢复Canvas坐标系统
                canvas?.restore()
            }
        }

        override fun onAnimationUpdate(animation: ValueAnimator?) {
            this.invalidate()
        }
    }
}