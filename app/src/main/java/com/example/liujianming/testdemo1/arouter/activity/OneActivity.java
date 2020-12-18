package com.example.liujianming.testdemo1.arouter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.arouter.test.Person;

public class OneActivity extends AppCompatActivity {

    private Button btn_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        btn_click = findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("/test/activity");
                ARouter.getInstance().build(uri)
                        .withLong("key1",666L)
                        .withString("key3","888")
                        .withSerializable("key4", new Person("Jack", 12))
                        .navigation();
            }
        });
    }
}