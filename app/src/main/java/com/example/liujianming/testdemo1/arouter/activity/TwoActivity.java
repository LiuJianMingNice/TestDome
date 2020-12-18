package com.example.liujianming.testdemo1.arouter.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.arouter.test.Person;

@Route(path = "/test/activity")
public class TwoActivity extends AppCompatActivity {

    @Autowired(name = "key1")
    public long data = 21L;

    @Autowired(name = "key4")
    public Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ARouter.getInstance().inject(this);
        Log.d("ljm","person===>>> " + person.getName() + "," + person.getAge());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}