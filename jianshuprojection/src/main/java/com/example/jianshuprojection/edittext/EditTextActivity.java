package com.example.jianshuprojection.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jianshuprojection.R;

public class EditTextActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showSoftInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editext);
        showSoftInput = findViewById(R.id.btn_showSoftInput);
        showSoftInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_showSoftInput:
                break;
        }
    }


}