package com.example.liuwangshu.内存泄露;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.OnClick;

import android.os.Bundle;

import com.example.liuwangshu.R;

public class TestActivity extends AppCompatActivity {

    ListItem40MClass head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    @OnClick(R.id.click_first)
    void onClick()  {
        if (head == null) {
            head = new ListItem40MClass();
        } else {
            ListItem40MClass tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListItem40MClass();
        }
    }
}