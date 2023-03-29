package com.example.liuwangshu.other.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liuwangshu.R;
import com.example.liuwangshu.other.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.second_tv_message)
    TextView tv_message;

    @BindView(R.id.second_bt_message)
    Button bt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        tv_message.setText("SecondActivity");
        bt_message.setText("发送事件");
        bt_message.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MessageEvent("欢迎"));
        finish();
    }
}