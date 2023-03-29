package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.csdnprojection.R;

public class MoveImageByKeyActivity extends AppCompatActivity {

    private static final int STEP = 10;
    private ImageView ivImageView;
    private LinearLayout root;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_image_by_key);

        ivImageView = findViewById(R.id.iv_image_view);
        root = findViewById(R.id.root);

        //设置根布局可以获得焦点
        root.setFocusable(true);
        root.setFocusableInTouchMode(true);
        //让根布局获得焦点
        root.requestFocus();
        root.requestFocusFromTouch();

        //获取图像控件的布局参数
        layoutParams = (LinearLayout.LayoutParams) ivImageView.getLayoutParams();

        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ljm", "ACTION_DOWN  X===>>> " + event.getX() + ",Y===>>> " + event.getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("ljm", "ACTION_MOVE  X===>>> " + event.getX() + ",Y===>>> " + event.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("ljm", "ACTION_UP  X===>>> " + event.getX() + ",Y===>>> " + event.getY());
                        break;
                }

                layoutParams.leftMargin = (int) event.getX();
                layoutParams.rightMargin = (int) event.getY();
                ivImageView.setLayoutParams(layoutParams);
                return true;
            }
        });

        //给根布局注册监听器
//        root.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Log.d("ljm", "keyCode===>>> " + keyCode);
//                switch (keyCode) {
//                    case KeyEvent.KEYCODE_DPAD_UP:
//                        //上边界检测碰撞
//                        if (ivImageView.getTop() >= 10) {
//                            layoutParams.topMargin = layoutParams.topMargin - STEP;
//                        } else {
//                            Toast.makeText(MoveImageByKeyActivity.this,"碰到上边界", Toast.LENGTH_SHORT).show();
//                        }
//                        break;
//                    case KeyEvent.KEYCODE_DPAD_DOWN:
//                        layoutParams.topMargin = layoutParams.topMargin + STEP;
//                        break;
//                    case KeyEvent.KEYCODE_DPAD_LEFT:
//                        layoutParams.leftMargin = layoutParams.leftMargin - STEP;
//                        break;
//                    case KeyEvent.KEYCODE_DPAD_RIGHT:
//                        layoutParams.rightMargin = layoutParams.rightMargin + STEP;
//                        break;
//                }
//                ivImageView.setLayoutParams(layoutParams);
//                return false;
//            }
//        });
    }
}