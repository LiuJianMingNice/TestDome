package com.example.liujianming.testdemo1.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;

public class HandlerTestActivity extends AppCompatActivity {

    private TextView mTextView;

    private Handler mHandler;

    private Handler mHandler1;

    private static final int MSG_UPDATE_UI = 0x2001;

    private static final int MSG_UPDATE_WAY_TWO = 0x2002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_test);

        mTextView = findViewById(R.id.text_click);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case MSG_UPDATE_UI:
                        mTextView.setText("修改界面");
                        break;
                    case MSG_UPDATE_WAY_TWO:
                        mTextView.setText("修改界面二");
                        break;
                }
            }
        };

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ljm","onClick====>>>");
//                try {
//                    Thread.sleep(300000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                sonThreadUpdateUI();
                createHandler();
                Message message = Message.obtain();
                message.what = MSG_UPDATE_UI;
                mHandler.sendMessage(message);
            }
        });
    }

    private void createHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                mHandler1 = new Handler();
            }
        }).start();
    }

    public void sonThreadUpdateUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText("修改界面");
            }
        }).start();
    }
}