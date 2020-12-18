package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.customview.PassWordEditText;

import java.util.Timer;
import java.util.TimerTask;

public class PassWordEditTextActivity extends AppCompatActivity {
    private PassWordEditText mPassWordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_edit_text);
        mPassWordEditText = findViewById(R.id.password_edittext);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }

    public void initView() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                InputMethodManager inputManager = (InputMethodManager) mPassWordEditText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(mPassWordEditText, 0);
            }

        }, 500);

        mPassWordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPassWordEditText.isClear(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}