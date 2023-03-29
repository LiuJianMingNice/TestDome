package com.example.csdnprojection.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.csdnprojection.R;
import com.example.csdnprojection.customview.BouncingBallView;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class BouncingBallActivity extends AppCompatActivity {

    //小球运动角度
    private double angle;

    //消息处理器
    private Handler handler;

    //线程循环控制变量
    private boolean isRunning;

    //自定义视图
    private BouncingBallView mBouncingBallView;

    //根布局
    private LinearLayout container;

    //移动步长
    private final int STEP = 5;

    //线程
    private Thread thread;

    //显示坐标的标签
    private TextView tvCoordinate;

    //十进制小数格式
    private DecimalFormat df;

    //定时器
    private Timer timer;

    //定时器任务
    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_fragment);

        tvCoordinate = findViewById(R.id.tv_coordinate);
        container = findViewById(R.id.container);

        mBouncingBallView = new BouncingBallView(this);
        mBouncingBallView.setBackgroundColor(Color.BLACK);
        mBouncingBallView.setLayoutParams(new LinearLayout.LayoutParams(400, 450));

        container.addView(mBouncingBallView);

        mBouncingBallView.setBallCenterX(mBouncingBallView.getLayoutParams().width / 2);
        mBouncingBallView.setBallCenterY(mBouncingBallView.getLayoutParams().height / 2);

        df = new DecimalFormat("#.##");

        tvCoordinate.setText("小球球心当前坐标(" + df.format(mBouncingBallView.getBallCenterX()) + "," + df.format(mBouncingBallView.getBallCenterY()) +")");

        // 创建消息处理器
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                if (msg.what == 0x001) {
                    /* 小球碰到边界，发生镜像反射 */
                    if (mBouncingBallView.getBallCenterX() + mBouncingBallView.getRadius() >= mBouncingBallView.getLayoutParams().width) { // 碰右边界
                        angle = Math.PI - angle;
                    } else if (mBouncingBallView.getBallCenterX() - mBouncingBallView.getRadius() <= 0) { // 碰左边界
                        angle = Math.PI - angle;
                    } else if (mBouncingBallView.getBallCenterY() - mBouncingBallView.getRadius() <= 0) { // 碰上边界
                        angle = -angle;
                    } else if (mBouncingBallView.getBallCenterY()
                            + mBouncingBallView.getRadius() >= mBouncingBallView.getLayoutParams().height) { // 碰下边界
                        angle = -angle;
                    }

                    /* 小球球心的新坐标 */
                    float newBallCenterX = (float) (mBouncingBallView.getBallCenterX() + STEP * Math.cos(angle));
                    float newBallCenterY = (float) (mBouncingBallView.getBallCenterY() - STEP * Math.sin(angle));

                    // 设置小球球心的新位置
                    mBouncingBallView.setBallCenterX(newBallCenterX);
                    mBouncingBallView.setBallCenterY(newBallCenterY);

                    // 显示小球新位置的坐标
                    tvCoordinate
                            .setText("小球球心当前坐标(" + df.format(newBallCenterX) + ", " + df.format(newBallCenterY) + ")");
                }
            };
        };

    }

    public void doStart(View view) {
        //设置小球运动初始角
        angle = 2 * Math.PI * Math.random();

//        //线程要循环
//        isRunning = true;
//        //创建子线程,往主线程发送消息
//        thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (isRunning) {
//                    handler.sendEmptyMessage(0X001);
//
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    mBouncingBallView.postInvalidate();
//                }
//            }
//        });
//        thread.start();

        //创建定时器
        if (timer == null) {
            timer = new Timer();
        }
        Log.d("ljm", "==run==>>>");
        //创建定时器任务
        task = new TimerTask() {
            @Override
            public void run() {
                Log.d("ljm", "==111==>>>");
                //往主线程发送消息
                handler.sendEmptyMessage(0X001);
                //延后刷屏
                mBouncingBallView.postInvalidate();
            }
        };
        Log.d("ljm", "==222==>>>");
        //对定时器任务进行调度
        timer.schedule(task, 0, 10);
        Log.d("ljm", "==333==>>>");
    }

    public void doStop(View view) {
        Log.d("ljm", "==doStop==>>>");
//        isRunning = false;
//        thread = null;
        //取消定时器任务
        timer.cancel();
        timer = null;
        Log.d("ljm", "==cancel==>>>");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        isRunning = false;
//        thread = null;
        //取消定时器任务
        timer.cancel();
        timer = null;
    }
}