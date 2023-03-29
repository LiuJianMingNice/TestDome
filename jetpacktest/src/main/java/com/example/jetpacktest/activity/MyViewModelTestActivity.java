package com.example.jetpacktest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jetpacktest.R;
import com.example.jetpacktest.viewmodel.MyViewModel;

public class MyViewModelTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_model_test);

        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
        model.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("ljm", "畅销书： " + s);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFileUri();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    private void getFileUri() {
        Log.d("ljm","getFileUri===>>> ");
        if (getIntent() != null) {
            String action = getIntent().getAction();
            Log.d("ljm","action: " + action);
            if (action == Intent.ACTION_VIEW) {
                Uri uri = getIntent().getData();
                Log.d("ljm","Uri: " + uri);
            }
        }
    }
}